package com.example.rickandmortyapi.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.data.repositories.pagingsources.EpisodePagingSources
import com.example.rickandmortyapi.models.EpisodeModel
import kotlinx.coroutines.flow.Flow

class EpisodeRepository {

    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodePagingSources(App.episodeApi!!)
            }).flow
    }
}

//    fun getSingleEpisode(id: Int): MutableLiveData<EpisodeModel> {
//        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
//        App.episodeApi?.fetchSingleEpisode(id)
//            ?.enqueue(object : Callback<EpisodeModel> {
//                override fun onResponse(
//                    call: Call<EpisodeModel>,
//                    response: Response<EpisodeModel>
//                ) {
//                    data.value = response.body()
//                }
//
//                override fun onFailure(
//                    call: Call<EpisodeModel>,
//                    t: Throwable
//                ) {
//                    data.value = null
//                }
//            })
//        return data
//    }
//}