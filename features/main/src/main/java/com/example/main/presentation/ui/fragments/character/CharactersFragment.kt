package com.example.main.presentation.ui.fragments.character

import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseFragment
import com.example.main.R
import com.example.main.databinding.FragmentCharactersBinding
import com.example.main.presentation.ui.adapters.CharactersPagingAdapter
import com.example.main.presentation.ui.fragments.filter.FilterBottomSheetFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment :
    BaseFragment<FragmentCharactersBinding, CharactersViewModel>(R.layout.fragment_characters),
    FilterBottomSheetFragment.FilterListener {

    override val binding: FragmentCharactersBinding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharactersViewModel by viewModel()
    private val adapter: CharactersPagingAdapter by lazy { CharactersPagingAdapter() }

    override fun constructListeners() {
        recyclerOnScrollListener()
        binding.btnFilter.setOnClickListener {
            FilterBottomSheetFragment(this).show(requireActivity().supportFragmentManager, "")
        }
    }

    override fun launchObservers() {
        binding.rvCharacters.adapter = adapter
        getDataFromSearchFragment()
        viewModel.getCharacters().spectatePaging { characters ->
            adapter.submitData(characters)
        }
    }

    private fun getDataFromSearchFragment() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            "searchFragment", this
        ) { _, result ->
            val name = result.getString("search")
            viewModel.getCharacters(name = name)
                .spectatePaging { searchData -> adapter.submitData(searchData) }
        }
    }

    override fun filtration(name: String, status: String, gender: String, species: String) {
        viewModel.getCharacters(
            name = name,
            status = status,
            gender = gender,
            species = species
        ).spectatePaging { filterCharacters ->
            adapter.submitData(filterCharacters)
        }
    }

    private fun recyclerOnScrollListener() {
        binding.rvCharacters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            private var isButtonVisible = true
            private var lastDy = 0

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && isButtonVisible) {
                    isButtonVisible = false
                    animateButton(false)
                }

                if (dy < 0 && !isButtonVisible) {
                    isButtonVisible = true
                    animateButton(true)
                }

                lastDy = dy
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE && !isButtonVisible && lastDy < 0) {
                    isButtonVisible = true
                    animateButton(true)
                }
            }
        })
    }

    private fun animateButton(show: Boolean) {
        val translationY = if (show) 0f else binding.btnFilter.height.toFloat()
        binding.btnFilter.animate().translationY(translationY).setDuration(300).start()
    }
}
