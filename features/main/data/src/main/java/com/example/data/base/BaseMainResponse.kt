package com.example.data.base

import com.example.data.remote.dtos.Info

data class BaseMainResponse<T>(
    val info: Info,
    val results:List<T>
)