package com.example.rickandmortyapi.data.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapi.data.remote.apiservices.CharacterApi
import com.example.rickandmortyapi.data.remote.apiservices.LocationApi
import com.example.rickandmortyapi.models.CharacterModel
import com.example.rickandmortyapi.models.LocationModel
import retrofit2.HttpException
import java.io.IOException

private const val  CHARACTER_STARTING_PAGE_INDEX = 1

class LocationPagingSources(private var locationService: LocationApi)
    : PagingSource<Int, LocationModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        return try {
            val responce = locationService.fetchLocations()
            val next = responce.info.next
            val nextPageNumber = if (next == null) {
                null
            } else
                Uri.parse(responce.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                data = responce.result,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException){
            return LoadResult.Error(exception)
        } catch (exception: HttpException){
            return LoadResult.Error(exception )
        }
    }
    override fun getRefreshKey(state: PagingState<Int, LocationModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
