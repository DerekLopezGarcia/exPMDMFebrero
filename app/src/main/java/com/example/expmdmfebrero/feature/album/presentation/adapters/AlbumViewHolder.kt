package com.example.expmdmfebrero.feature.album.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.expmdmfebrero.R
import com.example.expmdmfebrero.databinding.ItemAlbumBinding
import com.example.expmdmfebrero.feature.album.domain.Album

class AlbumViewHolder(
    private val binding: ItemAlbumBinding,
    private val onFavoriteClick: (Album) -> Unit,
    private val isFavorite: (Album) -> Boolean,
    private val onItemClick: (Album) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(album: Album) {
        with(binding) {
            albumName.text = album.name
            albumDate.text = album.creationDate
            albumDescription.text = album.description

            Glide.with(albumImage).load(album.imageUrl).placeholder(R.drawable.ic_plachodlerimage)
                .into(albumImage)

            val favoriteIcon = if (isFavorite(album)) {
                R.drawable.ic_bookmark_filled
            } else {
                R.drawable.ic_bookmark
            }
            favoriteButton.setImageResource(favoriteIcon)

            favoriteButton.setOnClickListener {
                onFavoriteClick(album)
            }
            favoriteButton.setOnClickListener {
                onFavoriteClick(album)
                val newIcon = if (isFavorite(album)) {
                    R.drawable.ic_bookmark_filled
                } else {
                    R.drawable.ic_bookmark
                }
                favoriteButton.setImageResource(newIcon)
            }
            root.setOnClickListener {
                onItemClick(album)
            }
        }
    }
}