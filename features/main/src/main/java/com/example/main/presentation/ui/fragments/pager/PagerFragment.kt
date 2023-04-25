package com.example.main.presentation.ui.fragments.pager

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseFragment
import com.example.main.R
import com.example.main.databinding.FragmentPagerBinding
import com.example.main.presentation.ui.adapters.PagerAdapter
import com.example.main.presentation.ui.fragments.search.SearchFragment
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class PagerFragment :
    BaseFragment<FragmentPagerBinding, NetworkStateViewModel>(R.layout.fragment_pager) {
    override val binding: FragmentPagerBinding by viewBinding(FragmentPagerBinding::bind)
    override val viewModel: NetworkStateViewModel by viewModel()

    override fun initialize() {
        initNetworkState()
    }

    private fun initNetworkState() {
        if (viewModel.networkState(requireContext())) {
            binding.pager.isVisible = true
            binding.pagerTab.isVisible = true
            binding.checkInternet.root.isGone = true
            initMenuOptions()
            initPagerTabs()
        } else {
            binding.checkInternet.root.isVisible = true
            binding.pager.isGone = true
            binding.pagerTab.isGone = true
        }
    }

    private fun initPagerTabs() {
        binding.pager.adapter = PagerAdapter(this)
        val fragmentsTabs = listOf(
            "Characters",
            "Episodes",
            "Locations"
        )

        TabLayoutMediator(binding.pagerTab, binding.pager) { tab, position ->
            tab.text = fragmentsTabs[position]
        }.attach()
    }

    private fun initMenuOptions() {
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return when (menuItem.itemId) {
                    R.id.search -> {
                        SearchFragment().show(requireActivity().supportFragmentManager, "")
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}