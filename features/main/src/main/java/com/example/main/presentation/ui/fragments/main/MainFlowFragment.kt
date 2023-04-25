package com.example.main.presentation.ui.fragments.main

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.base.BaseFragmentWithoutViewModel
import com.example.main.R
import com.example.main.databinding.FragmentMainFlowBinding

class MainFlowFragment :
    BaseFragmentWithoutViewModel<FragmentMainFlowBinding>(R.layout.fragment_main_flow) {
    override val binding: FragmentMainFlowBinding by viewBinding(FragmentMainFlowBinding::bind)
}