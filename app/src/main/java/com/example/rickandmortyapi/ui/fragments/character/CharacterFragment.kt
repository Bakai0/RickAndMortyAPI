package com.example.rickandmortyapi.ui.fragments.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.databinding.FragmentCharacterBinding
import com.example.rickandmortyapi.models.CharacterModel
import com.example.rickandmortyapi.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment() {

    private var viewModel: CharacterViewModel? = null
    private lateinit var binding: FragmentCharacterBinding
    private var characterAdapter = CharacterAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.characterRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
            Toast.makeText(context, "nvnfdhvjk", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupObserve() {
        viewModel?.fetchCharacters()?.observe(viewLifecycleOwner) {
            characterAdapter.submitList(it?.result)
        }
    }

    private fun onItemClick(args: CharacterModel) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToSingleFragment(
                args
            )
        )
    }
}

