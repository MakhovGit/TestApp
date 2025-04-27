package com.example.app.testapp.network.repository

import android.content.Context
import com.example.app.testapp.core.domain.course.Courses
import com.example.app.testapp.network.data.dto.CoursesDto
import com.example.app.testapp.network.data.mappers.NetworkMapper
import com.example.app.testapp.network.utils.FileUtils.readJsonFromAssets
import kotlinx.serialization.json.Json

class NetworkRepositoryImpl : NetworkRepository {

    private val filename = "courses.json"
    private val customJson = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    override fun getCourses(context: Context): Courses {
        val jsonString = readJsonFromAssets(context, filename)
        val coursesDto = customJson.decodeFromString<CoursesDto>(jsonString)
        return NetworkMapper.map(coursesDto)
    }

}