package com.example.data.remote.dtos

import com.example.data.mapper.DataMapper
import com.example.domain.model.OriginModel
import com.google.gson.annotations.SerializedName

data class OriginDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) : DataMapper<OriginModel> {
    override fun toDomain() = OriginModel(
        name = name,
        url = url,
    )
}