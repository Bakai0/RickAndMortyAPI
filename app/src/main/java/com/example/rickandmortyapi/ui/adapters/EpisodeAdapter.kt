package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.ItemEpisodeBinding
import com.example.rickandmortyapi.models.EpisodeModel

class EpisodeAdapter: PagingDataAdapter<EpisodeModel, EpisodeAdapter.EpisodeViewHolder>(DiffUtilCallback()) {

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(episodeModel: EpisodeModel) {
            binding.itemEpisodeEpisode.text = episodeModel.episode
            binding.itemEpisodeAirDate.text = episodeModel.air_date
            binding.itemEpisodeCreated.text = episodeModel.created
            binding.itemLocationName.text = episodeModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}

class DiffUtilCallback : DiffUtil.ItemCallback<EpisodeModel>(){
    override fun areItemsTheSame(oldItem: EpisodeModel, newItem: EpisodeModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EpisodeModel, newItem: EpisodeModel): Boolean {
        return oldItem == newItem
    }
}