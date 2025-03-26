plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = ScreenOnboardingConfig.nameSpace
    compileSdk = ScreenOnboardingConfig.compileSdk

    defaultConfig {
        minSdk = ScreenOnboardingConfig.minSdk

        testInstrumentationRunner = ScreenOnboardingConfig.testInstrumentationRunner
        consumerProguardFiles(ScreenOnboardingConfig.consumerRulesFile)
    }

    buildTypes {
        release {
            isMinifyEnabled = ScreenOnboardingConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(ScreenOnboardingConfig.proguardAndroidOptimiseFile),
                ScreenOnboardingConfig.proguardRulesFile
            )
        }
    }
    buildFeatures {
        viewBinding = ScreenOnboardingConfig.viewBinding
    }
    compileOptions {
        sourceCompatibility = ScreenOnboardingConfig.sourceCompatibility
        targetCompatibility = ScreenOnboardingConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = ScreenOnboardingConfig.jvmTarget
    }
}

dependencies {

    // Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}