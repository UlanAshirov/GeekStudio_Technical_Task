package com.example.main.presentation.ui.fragments.pager

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseFragment
import com.example.core.ext.gone
import com.example.core.ext.visible
import com.example.main.R
import com.example.main.databinding.FragmentPagerBinding
import com.example.main.presentation.ui.adapters.PagerAdapter
import com.example.main.presentation.ui.fragments.search.SearchFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PagerFragment :
    BaseFragment<FragmentPagerBinding, NetworkStateViewModel>(R.layout.fragment_pager) {
    override val binding: FragmentPagerBinding by viewBinding(FragmentPagerBinding::bind)
    override val viewModel: NetworkStateViewModel by viewModel()
    override fun initialize() {
        initNetworkState()
        initMenuOptions()
    }

    private fun initNetworkState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isConnected.collectLatest { isConnectivity ->
                if (isConnectivity) {
                    initPagerTabs()
                    binding.checkInternet.root.gone()
                    binding.pagerTab.visible()
                    binding.pager.visible()
                } else {
                    binding.checkInternet.root.visible()
                    binding.pagerTab.gone()
                    binding.pager.gone()
                }
            }
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