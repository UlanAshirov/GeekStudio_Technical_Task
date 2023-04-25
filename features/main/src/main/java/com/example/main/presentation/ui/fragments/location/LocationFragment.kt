package com.example.main.presentation.ui.fragments.location

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseFragment
import com.example.main.R
import com.example.main.databinding.FragmentLocationBinding
import com.example.main.presentation.ui.adapters.LocationPagingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding: FragmentLocationBinding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModel()
    private val adapter: LocationPagingAdapter by lazy { LocationPagingAdapter() }


    override fun launchObservers() {
        binding.rvLocation.adapter = adapter

        viewModel.getLocation().spectatePaging { locations ->
            adapter.submitData(locations)
        }
        getDataFromSearchFragment()
    }

    private fun getDataFromSearchFragment() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            "searchFragment", this
        ) { _, result ->
            val name = result.getString("search")
            viewModel.getLocation(name = name)
                .spectatePaging { searchData -> adapter.submitData(searchData) }
        }
    }
}