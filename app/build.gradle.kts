plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = AppConfig.nameSpace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = AppConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(AppConfig.proguardAndroidOptimiseFile),
                AppConfig.proguardRulesFile
            )
        }
    }
    buildFeatures {
        viewBinding = AppConfig.viewBinding
    }
    compileOptions {
        sourceCompatibility = AppConfig.sourceCompatibility
        targetCompatibility = AppConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {

    // Modules
    implementation(project(Modules.CORE))
    implementation(project(Modules.NAVIGATION))
    implementation(project(Modules.SCREEN_ONBOARDING))
    implementation(project(Modules.SCREEN_LOGIN))
    implementation(project(Modules.SCREEN_MAIN))
    implementation(project(Modules.SCREEN_FAVORITES))
    implementation(project(Modules.SCREEN_ACCOUNT))

    // Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Navigation
    implementation(libs.navigation.ui.ktx)
    implementation(libs.navigation.fragment.ktx)

    // BlurView
    implementation(libs.blurview)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}