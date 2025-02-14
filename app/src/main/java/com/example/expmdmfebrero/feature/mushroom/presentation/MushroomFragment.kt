package com.example.expmdmfebrero.feature.mushroom.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.expmdmfebrero.databinding.MushroomFragmentBinding
import com.example.expmdmfebrero.feature.mushroom.domain.MushroomCard
import com.example.expmdmfebrero.feature.mushroom.presentation.adapters.MushroomAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MushroomFragment : Fragment() {
    private val viewModel: MushroomViewModel by viewModel()
    private var _binding: MushroomFragmentBinding? = null
    private val binding get() = _binding!!
    private val args: MushroomFragmentArgs by navArgs()
    private lateinit var mushroomAdapter: MushroomAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MushroomFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
        viewModel.loadMushroomCards(args.albumName)
    }

    private fun setupViews() {
        mushroomAdapter = MushroomAdapter()
        binding.recyclerView.adapter = mushroomAdapter
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }

    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            uiState.isLoading.let {
                false
            }
            uiState.mushroomCards.let { mushroomCards ->
                bindData(mushroomCards)
            }
            uiState.error.let {
                // Handle error state
            }
        }
    }
    private fun bindData(mushrooms : List<MushroomCard>) {
       binding.apply {
           mushroomAdapter.updateMushrooms(mushrooms)
       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}