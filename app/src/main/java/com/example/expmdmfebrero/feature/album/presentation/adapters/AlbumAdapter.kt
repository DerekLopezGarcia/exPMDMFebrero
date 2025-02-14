package com.example.expmdmfebrero.feature.album.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expmdmfebrero.databinding.ItemAlbumBinding
import com.example.expmdmfebrero.feature.album.domain.Album
import com.example.expmdmfebrero.feature.album.presentation.adapters.AlbumViewHolder

class AlbumAdapter(
    private var albums: List<Album>,
    private val onFavoriteClick: (Album) -> Unit,
    private val isFavorite: (Album) -> Boolean,
    private val onItemClick: (Album) -> Unit
) : RecyclerView.Adapter<AlbumViewHolder>() {

    fun updateAlbums(newAlbums: List<Album>) {
        albums = newAlbums
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding, onFavoriteClick, isFavorite, onItemClick)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(albums[position])
    }

    override fun getItemCount(): Int = albums.size
}