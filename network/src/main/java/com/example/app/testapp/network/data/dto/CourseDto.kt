package com.example.app.testapp.network.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CourseDto(

    @SerialName("id")
    val id: Long? = null,

    @SerialName("title")
    val title: String? = null,

    @SerialName("text")
    val text: String? = null,

    @SerialName("price")
    val price: String? = null,

    @SerialName("rate")
    val rate: Float? = null,

    @SerialName("startDate")
    val startDate: String? = null,

    @SerialName("publishDate")
    val publishDate: String? = null
)
