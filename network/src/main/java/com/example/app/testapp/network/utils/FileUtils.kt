package com.example.app.testapp.network.utils

import android.content.Context

internal object FileUtils {
    fun readJsonFromAssets(context: Context, fileName: String): String =
        context.assets.open(fileName).bufferedReader().use { it.readText() }

}