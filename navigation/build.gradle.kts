plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = NavigationConfig.nameSpace
    compileSdk = NavigationConfig.compileSdk

    defaultConfig {
        minSdk = NavigationConfig.minSdk

        testInstrumentationRunner = NavigationConfig.testInstrumentationRunner
        consumerProguardFiles(NavigationConfig.consumerRulesFile)
    }

    buildTypes {
        release {
            isMinifyEnabled = NavigationConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(NavigationConfig.proguardAndroidOptimiseFile),
                NavigationConfig.proguardRulesFile
            )
        }
    }
    compileOptions {
        sourceCompatibility = NavigationConfig.sourceCompatibility
        targetCompatibility = NavigationConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = NavigationConfig.jvmTarget
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