plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = ScreenMainConfig.nameSpace
    compileSdk = ScreenMainConfig.compileSdk

    defaultConfig {
        minSdk = ScreenMainConfig.minSdk

        testInstrumentationRunner = ScreenMainConfig.testInstrumentationRunner
        consumerProguardFiles(ScreenMainConfig.consumerRulesFile)
    }

    buildTypes {
        release {
            isMinifyEnabled = ScreenMainConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(ScreenMainConfig.proguardAndroidOptimiseFile),
                ScreenMainConfig.proguardRulesFile
            )
        }
    }
    buildFeatures {
        viewBinding = ScreenMainConfig.viewBinding
    }
    compileOptions {
        sourceCompatibility = ScreenMainConfig.sourceCompatibility
        targetCompatibility = ScreenMainConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = ScreenMainConfig.jvmTarget
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