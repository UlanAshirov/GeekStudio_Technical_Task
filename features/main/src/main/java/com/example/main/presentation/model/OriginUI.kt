package com.example.main.presentation.model

import com.example.domain.model.OriginModel

data class OriginUI(
    val name: String,
    val url: String
)

fun OriginModel.toUI() = OriginUI(
    name = name,
    url = url
)