package com.example.main.presentation.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.main.presentation.ui.fragments.character.CharactersFragment
import com.example.main.presentation.ui.fragments.episode.EpisodeFragment
import com.example.main.presentation.ui.fragments.location.LocationFragment

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CharactersFragment()
            1 -> EpisodeFragment()
            2 -> LocationFragment()
            else -> CharactersFragment()
        }
    }
}