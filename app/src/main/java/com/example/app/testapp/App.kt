package com.example.app.testapp

import android.app.Application
import com.example.app.testapp.di.appKoinModule
import com.example.app.testapp.screen_favorites.di.screenFavoritesKoinModule
import com.example.app.testapp.screen_login.di.screenLoginKoinModule
import com.example.app.testapp.screen_main.di.screenMainKoinModule
import com.example.app.testapp.screen_onboarding.di.screenOnboardingKoinModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    private val koinModules = listOf(
        appKoinModule,
        screenOnboardingKoinModule,
        screenLoginKoinModule,
        screenMainKoinModule,
        screenFavoritesKoinModule
    )

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(koinModules)
        }
    }

    private fun initAndroidThreeTen(app: Application) {
        AndroidThreeTen.init(app)
    }

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initAndroidThreeTen(this)
    }

}