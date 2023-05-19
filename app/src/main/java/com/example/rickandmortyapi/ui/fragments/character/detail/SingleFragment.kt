package com.example.rickandmortyapi.ui.fragments.character.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.databinding.FragmentSingleBinding

class SingleFragment : Fragment() {

    private var viewModel: SingleViewModel? = null
    private lateinit var binding: FragmentSingleBinding
    private val args by navArgs<SingleFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[SingleViewModel::class.java]
        binding = FragmentSingleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserves()
    }

    private fun setupObserves() {
        viewModel?.fetchSingleCharacter(args.id.id)?.observe(viewLifecycleOwner) {
            binding?.tvTextDetail?.text = args.id.name
            Glide.with(binding.imgCharacterDetailPerson).load(args.id.image)
                .into(binding.imgCharacterDetailPerson)
        }
    }
}
