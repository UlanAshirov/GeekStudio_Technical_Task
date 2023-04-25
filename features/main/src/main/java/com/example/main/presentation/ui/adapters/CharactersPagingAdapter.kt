package com.example.main.presentation.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core.ext.loadImage
import com.example.main.databinding.ItemCharactersBinding
import com.example.main.presentation.model.CharacterUI

class CharactersPagingAdapter :
    PagingDataAdapter<CharacterUI, CharactersPagingAdapter.CharactersViewHolder>(
        DiffCharacterCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharactersViewHolder(
        ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }

    class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: CharacterUI?) {
            model?.image?.let { binding.itemImgCharacters.loadImage(it) }
            binding.itemNameCharacters.text = model?.name
            binding.itemStatusCharacters.text = model?.status
            binding.itemGenderCharacters.text = model?.gender
            binding.itemSpeciesCharacters.text = model?.species

            when (model?.status) {
                "Alive" -> binding.itemStatusCharacters.setTextColor(
                    Color.parseColor("#61F605")
                )
                "Dead" -> binding.itemStatusCharacters.setTextColor(
                    Color.parseColor("#F60505")
                )
                "unknown" -> binding.itemStatusCharacters.setTextColor(
                    Color.parseColor("#6B6E798C")
                )
            }
            when (model?.gender) {
                "Male" -> binding.itemGenderCharacters.setTextColor(
                    Color.parseColor("#429ADF")
                )
                "Female" -> binding.itemGenderCharacters.setTextColor(
                    Color.parseColor("#DD2363")
                )
                "unknown" -> binding.itemGenderCharacters.setTextColor(
                    Color.parseColor("#6B6E798C")
                )
            }
        }
    }

    class DiffCharacterCallback : DiffUtil.ItemCallback<CharacterUI>() {
        override fun areItemsTheSame(oldItem: CharacterUI, newItem: CharacterUI) =
            oldItem == newItem


        override fun areContentsTheSame(oldItem: CharacterUI, newItem: CharacterUI) =
            oldItem == newItem

    }
}