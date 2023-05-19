package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.databinding.ItemCharacterBinding
import com.example.rickandmortyapi.models.CharacterModel
import kotlin.reflect.KFunction1

class CharacterAdapter( val onItemClick: (dan: CharacterModel) -> Unit) :
    ListAdapter<CharacterModel, CharacterAdapter.ViewHolder>(DiffUtilCallback()) {

     inner class ViewHolder ( private val binding: ItemCharacterBinding):
            RecyclerView.ViewHolder(binding.root) {
         init {
             itemView.setOnClickListener {
                 onItemClick(getItem(adapterPosition))
             }
         }
        fun onBind(item: CharacterModel?) {
            Glide.with(binding.itemCharacterImage).load(item?.image)
                .into(binding.itemCharacterImage)
            binding.itemCharacterName.text = item?.name
            binding.itemCharacterGender.text = item?.gender
            binding.itemCharacterStatus.text = item?.status
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
    class DiffUtilCallback : DiffUtil.ItemCallback<CharacterModel>(){
        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem == newItem
        }
    }
}