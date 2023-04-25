package com.example.main.presentation.ui.fragments.episode

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseFragment
import com.example.main.R
import com.example.main.databinding.FragmentEpisodeBinding
import com.example.main.presentation.ui.adapters.EpisodePagingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment(
) : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding: FragmentEpisodeBinding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModel()
    private val adapter: EpisodePagingAdapter by lazy { EpisodePagingAdapter() }

    override fun launchObservers() {
        binding.rvEpisodes.adapter = adapter
        getDataFromSearchFragment()
        viewModel.getEpisode().spectatePaging { episodes ->
            adapter.submitData(episodes)
        }
    }

    private fun getDataFromSearchFragment() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            "searchFragment", this
        ) { _, result ->
            val name = result.getString("search")
            viewModel.getEpisode(name = name)
                .spectatePaging { searchData -> adapter.submitData(searchData) }
        }
    }
}