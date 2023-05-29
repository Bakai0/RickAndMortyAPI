package com.example.rickandmortyapi.data.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import com.example.rickandmortyapi.data.remote.apiservices.CharacterApi
import com.example.rickandmortyapi.models.CharacterModel
import retrofit2.HttpException
import java.io.IOException
import androidx.paging.PagingState as PagingState

private const val  CHARACTER_STARTING_PAGE_INDEX = 1

class CharacterPagingSource(private var service: CharacterApi)
    : PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        return try {
            val responce = service.fetchCharacters()
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
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
