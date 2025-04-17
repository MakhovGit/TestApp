plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = ScreenFavoritesConfig.nameSpace
    compileSdk = ScreenFavoritesConfig.compileSdk

    defaultConfig {
        minSdk = ScreenFavoritesConfig.minSdk

        testInstrumentationRunner = ScreenFavoritesConfig.testInstrumentationRunner
        consumerProguardFiles(ScreenFavoritesConfig.consumerRulesFile)
    }

    buildTypes {
        release {
            isMinifyEnabled = ScreenFavoritesConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(ScreenFavoritesConfig.proguardAndroidOptimiseFile),
                ScreenFavoritesConfig.proguardRulesFile
            )
        }
    }
    buildFeatures {
        viewBinding = ScreenFavoritesConfig.viewBinding
    }
    compileOptions {
        sourceCompatibility = ScreenFavoritesConfig.sourceCompatibility
        targetCompatibility = ScreenFavoritesConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = ScreenFavoritesConfig.jvmTarget
    }
}

dependencies {

    // Modules
    implementation(project(Modules.CORE))

    // Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}