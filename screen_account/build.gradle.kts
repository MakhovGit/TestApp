plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = ScreenAccountConfig.nameSpace
    compileSdk = ScreenAccountConfig.compileSdk

    defaultConfig {
        minSdk = ScreenAccountConfig.minSdk

        testInstrumentationRunner = ScreenAccountConfig.testInstrumentationRunner
        consumerProguardFiles(ScreenAccountConfig.consumerRulesFile)
    }

    buildTypes {
        release {
            isMinifyEnabled = ScreenAccountConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(ScreenAccountConfig.proguardAndroidOptimiseFile),
                ScreenAccountConfig.proguardRulesFile
            )
        }
    }
    buildFeatures {
        viewBinding = ScreenAccountConfig.viewBinding
    }
    compileOptions {
        sourceCompatibility = ScreenAccountConfig.sourceCompatibility
        targetCompatibility = ScreenAccountConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = ScreenAccountConfig.jvmTarget
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