package com.example.rickandmortyapi.ui.fragments.location

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.databinding.FragmentLocationBinding
import com.example.rickandmortyapi.ui.activity.MainActivity
import com.example.rickandmortyapi.ui.adapters.LocationAdapter
import kotlinx.coroutines.launch

class LocationFragment:
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private var locationAdapter = LocationAdapter()

    override fun initialize() {
        binding.locationRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
            Toast.makeText(context, "vndjh", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchLocation().collect {
                locationAdapter.submitData(it)
            }
        }
    }
    override fun bottomNavigationSelected() {
        (requireActivity() as MainActivity).setOnItemReselectedListener() {
            binding.locationRecView.smoothScrollToPosition(0)
        }
    }
}

