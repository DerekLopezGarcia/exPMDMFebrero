package com.example.expmdmfebrero.feature.mushroom.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.expmdmfebrero.R
import com.example.expmdmfebrero.databinding.ItemMushroomBinding
import com.example.expmdmfebrero.feature.mushroom.domain.MushroomCard

class MushroomViewHolder(
    private val binding: ItemMushroomBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(mushroom: MushroomCard) {
        binding.mushroomName.text = mushroom.name
        Glide.with(binding.mushroomImage)
            .load(mushroom.imageUrl)
            .placeholder(R.drawable.ic_plachodlerimage)
            .into(binding.mushroomImage)
    }
}