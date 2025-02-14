package com.example.expmdmfebrero.feature.mushroom.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expmdmfebrero.databinding.ItemMushroomBinding
import com.example.expmdmfebrero.feature.mushroom.domain.MushroomCard

class MushroomAdapter : RecyclerView.Adapter<MushroomViewHolder>() {
    private var mushrooms: List<MushroomCard> = emptyList()

    fun updateMushrooms(newMushrooms: List<MushroomCard>) {
        mushrooms = newMushrooms
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MushroomViewHolder {
        val binding = ItemMushroomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MushroomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MushroomViewHolder, position: Int) {
        holder.bind(mushrooms[position])
    }

    override fun getItemCount(): Int = mushrooms.size
}