package com.example.main.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.main.databinding.ItemLocationBinding
import com.example.main.presentation.model.LocationUI

class LocationPagingAdapter :
    PagingDataAdapter<LocationUI, LocationPagingAdapter.LocationViewHolder>(DiffLocationCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LocationViewHolder(
        ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }

    class LocationViewHolder(private val binding: ItemLocationBinding) : ViewHolder(binding.root) {
        fun onBind(model: LocationUI?) {
            binding.itemLocationType.text = model?.type
            binding.itemLocationName.text = model?.name
        }
    }

    class DiffLocationCallback : DiffUtil.ItemCallback<LocationUI>() {
        override fun areItemsTheSame(oldItem: LocationUI, newItem: LocationUI) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: LocationUI, newItem: LocationUI) =
            oldItem == newItem
    }
}