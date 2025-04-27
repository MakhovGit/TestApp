package com.example.app.testapp.network.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CoursesDto(

    @SerialName("courses")
    val courses: List<CourseDto>? = null
)