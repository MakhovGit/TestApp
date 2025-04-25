plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = ScreenLoginConfig.nameSpace
    compileSdk = ScreenLoginConfig.compileSdk

    defaultConfig {
        minSdk = ScreenLoginConfig.minSdk

        testInstrumentationRunner = ScreenLoginConfig.testInstrumentationRunner
        consumerProguardFiles(ScreenLoginConfig.consumerRulesFile)
    }

    buildTypes {
        release {
            isMinifyEnabled = ScreenLoginConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(ScreenLoginConfig.proguardAndroidOptimiseFile),
                ScreenLoginConfig.proguardRulesFile
            )
        }
    }
    buildFeatures {
        viewBinding = ScreenOnboardingConfig.viewBinding
    }
    compileOptions {
        sourceCompatibility = ScreenLoginConfig.sourceCompatibility
        targetCompatibility = ScreenLoginConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = ScreenLoginConfig.jvmTarget
    }
}

dependencies {

    // Modules
    implementation(project(Modules.CORE))
    implementation(project(Modules.NAVIGATION))

    // Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Koin
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.bundles.koin.bundle)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}