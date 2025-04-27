package com.example.app.testapp.network.repository

import android.content.Context
import com.example.app.testapp.core.domain.course.Courses

interface NetworkRepository {
    fun getCourses(context: Context): Courses
}