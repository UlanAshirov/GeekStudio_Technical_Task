package com.example.main.presentation.ui.fragments.search

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseBottomSheetDialogFragment
import com.example.main.R
import com.example.main.databinding.FragmentSearchBinding

class SearchFragment :
    BaseBottomSheetDialogFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)

    override fun initialize() {
        binding.itemBtnSearch.setOnClickListener {
            val searchName = binding.itemEtSearch.text.toString()
            val bundle = Bundle()
            bundle.putString("search", searchName)
            requireActivity().supportFragmentManager.setFragmentResult("searchFragment", bundle)
            onDestroyView()
        }
    }
}