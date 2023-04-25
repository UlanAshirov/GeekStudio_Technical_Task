package com.example.main.presentation.ui.fragments.filter

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseBottomSheetDialogFragment
import com.example.core.base.BaseFragmentWithoutViewModel
import com.example.main.R
import com.example.main.databinding.FragmentFilterBottomSheetBinding

class FilterBottomSheetFragment(private val listener: FilterListener) :
    BaseBottomSheetDialogFragment<FragmentFilterBottomSheetBinding>(
        R.layout.fragment_filter_bottom_sheet
    ) {
    override val binding: FragmentFilterBottomSheetBinding by viewBinding(
        FragmentFilterBottomSheetBinding::bind
    )

    private var search = ""
    private var status = ""
    private var gender = ""
    private var species = ""

    override fun initialize() {
        initStatus()
        initGender()
        initSpecies()

        binding.btnApply.setOnClickListener {
            search = binding.etFilterName.text.toString()

            listener.filtration(
                name = search,
                status = status,
                gender = gender,
                species = species
            )
            dismiss()
        }

        binding.btnReset.setOnClickListener {
            listener.filtration(
                name = "",
                status = "",
                gender = "",
                species = ""
            )
            dismiss()
        }
    }

    private fun initStatus() {
        binding.rgStatus.setOnCheckedChangeListener { _, id ->
            status = when (id) {
                binding.rbAlive.id -> "Alive"
                binding.rbStatusUnknown.id -> "unknown"
                binding.rbDead.id -> "Dead"
                else -> ""
            }
        }
    }

    private fun initGender() {
        binding.rgGender.setOnCheckedChangeListener { _, id ->
            gender = when (id) {
                binding.rbFemale.id -> "Female"
                binding.rbMale.id -> "Male"
                binding.rbGenderUnknown.id -> "unknown"
                else -> ""
            }
        }
    }

    private fun initSpecies() {
        binding.rgSpecies.setOnCheckedChangeListener { _, id ->
            species = when (id) {
                binding.rbHuman.id -> "Human"
                binding.rbAlien.id -> "Alien"
                binding.rbHumanoid.id -> "Humanoid"
                else -> ""
            }
        }
    }

    interface FilterListener {
        fun filtration(
            name: String,
            status: String,
            gender: String,
            species: String
        )
    }
}