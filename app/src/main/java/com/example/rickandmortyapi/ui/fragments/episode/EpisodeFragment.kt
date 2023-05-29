package com.example.rickandmortyapi.ui.fragments.episode

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.databinding.FragmentEpisodeBinding
import com.example.rickandmortyapi.ui.activity.MainActivity
import com.example.rickandmortyapi.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.launch

class EpisodeFragment:
    BaseFragment<FragmentEpisodeBinding, SharedEpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: SharedEpisodeViewModel by viewModels()
    private var episodeAdapter = EpisodeAdapter()

    override fun initialize() {
        binding.episodeRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
            Toast.makeText(context, "vndjh", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchEpisode().collect {
                episodeAdapter.submitData(it)
            }
        }
    }
    override fun bottomNavigationSelected() {
        (requireActivity() as MainActivity).setOnItemReselectedListener() {
            binding.episodeRecView.smoothScrollToPosition(0)
        }
    }
}


