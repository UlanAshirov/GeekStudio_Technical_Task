package com.example.main.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.main.databinding.ItemEpisodesBinding
import com.example.main.presentation.model.EpisodeUI

class EpisodePagingAdapter :
    PagingDataAdapter<EpisodeUI, EpisodePagingAdapter.EpisodeViewHolder>(DiffEpisodeCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodeViewHolder(
        ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }

    class EpisodeViewHolder(private val binding: ItemEpisodesBinding) : ViewHolder(binding.root) {
        fun onBind(model: EpisodeUI?) {
            binding.itemNameEpisode.text = model?.name
            binding.itemEpisode.text = model?.episode
            binding.itemEpisodeCreate.text = model?.airDate
        }

    }

    class DiffEpisodeCallback : DiffUtil.ItemCallback<EpisodeUI>() {
        override fun areItemsTheSame(oldItem: EpisodeUI, newItem: EpisodeUI) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: EpisodeUI, newItem: EpisodeUI) =
            oldItem == newItem
    }
}