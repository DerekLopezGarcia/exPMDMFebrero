package com.example.expmdmfebrero.feature.album.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expmdmfebrero.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.expmdmfebrero.databinding.AlbumFragmentBinding
import com.example.expmdmfebrero.feature.album.domain.Album

class AlbumFragment : Fragment() {
    private val viewModel: AlbumViewModel by viewModel()
    private var _binding: AlbumFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var albumAdapter: AlbumAdapter
    private var favoriteMenuItem: MenuItem? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AlbumFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
        setupToolbar()
        viewModel.loadAlbums()
    }

    private fun setupToolbar() {
        binding.toolbar.apply {
            menu.clear()
            inflateMenu(R.menu.menu_album)
            favoriteMenuItem = menu.findItem(R.id.action_favorites)
            updateFavoriteIcon(viewModel.isShowingOnlyFavorites())

            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_favorites -> {
                        viewModel.toggleFavoriteFilter()
                        updateFavoriteIcon(viewModel.isShowingOnlyFavorites())
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun updateFavoriteIcon(showingOnlyFavorites: Boolean) {
        favoriteMenuItem?.setIcon(
            if (showingOnlyFavorites) R.drawable.ic_bookmark_filled
            else R.drawable.ic_bookmark
        )
    }

    private fun setupViews() {
        albumAdapter = AlbumAdapter(
            emptyList(),
            { album -> viewModel.toggleFavorite(album.name) },
            { album -> viewModel.isFavorite(album.name) },
            { album -> navigateToMushrooms(album) }
        )
        binding.recyclerView.adapter = albumAdapter
    }
    private fun navigateToMushrooms(album: Album) {
        findNavController().navigate(
            R.id.action_albumFragment_to_mushroomFragment,
            Bundle().apply {
                putString("albumName", album.name)
            }
        )
    }


    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            uiState.isLoading.let { isLoading ->
                // Handle loading state
            }
            uiState.albums.let { albums ->
                bindData(albums)
            }
            uiState.error?.let { error ->
                // Handle error state
            }
        }
    }

    private fun bindData(albums: List<Album>) {
        albumAdapter.updateAlbums(albums)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}