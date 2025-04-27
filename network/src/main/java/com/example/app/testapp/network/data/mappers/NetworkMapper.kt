package com.example.app.testapp.network.data.mappers

import com.example.app.testapp.core.domain.course.Course
import com.example.app.testapp.core.domain.course.Courses
import com.example.app.testapp.core.extensions.EMPTY
import com.example.app.testapp.core.extensions.ZERO
import com.example.app.testapp.core.extensions.toMillisFromDateLocal
import com.example.app.testapp.network.data.dto.CourseDto
import com.example.app.testapp.network.data.dto.CoursesDto

internal object NetworkMapper {

    private fun map(input: CourseDto?) =
        Course(
            id = input?.id ?: Long.ZERO,
            title = input?.title ?: String.EMPTY,
            text = input?.text ?: String.EMPTY,
            price = input?.price?.toIntOrNull() ?: Int.ZERO,
            rate = input?.rate ?: Float.ZERO,
            startDate = input?.startDate?.toMillisFromDateLocal() ?: Long.ZERO,
            hasLike = false,
            publishDate = input?.publishDate?.toMillisFromDateLocal() ?: Long.ZERO
        )

    fun map(input: CoursesDto?) =
        Courses(
            courses = input?.courses?.map { map(it) } ?: listOf()
        )
}