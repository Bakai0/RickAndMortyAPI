package com.example.rickandmortyapi.ui.fragments.character.detail

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.databinding.FragmentSingleBinding
import com.example.rickandmortyapi.ui.fragments.character.SharedViewModel

class SingleFragment :
    BaseFragment<FragmentSingleBinding, SharedViewModel>(R.layout.fragment_single) {

    override val binding by viewBinding(FragmentSingleBinding::bind)
    override val viewModel: SharedViewModel by activityViewModels()
    private val args by navArgs<SingleFragmentArgs>()

    override fun setupObserves() {
        viewModel?.fetchSingleCharacter(args.id.id)?.observe(viewLifecycleOwner) {
            binding.tvTextDetail.text = args.id.name
            Glide.with(binding.imgCharacterDetailPerson).load(args.id.image)
                .into(binding.imgCharacterDetailPerson)
        }
    }
}
