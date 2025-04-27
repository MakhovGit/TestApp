package com.example.app.testapp.core.domain.course

import com.example.app.testapp.core.extensions.EMPTY
import com.example.app.testapp.core.extensions.ZERO

data class Course(
    val id: Long = Long.ZERO,
    val title: String = String.EMPTY,
    val text: String = String.EMPTY,
    val price: Int = Int.ZERO,
    val rate: Float = Float.ZERO,
    val startDate: Long = Long.ZERO,
    val hasLike: Boolean = false,
    val publishDate: Long = Long.ZERO
)
