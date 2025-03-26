plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = CoreConfig.nameSpace
    compileSdk = CoreConfig.compileSdk

    defaultConfig {
        minSdk = CoreConfig.minSdk

        testInstrumentationRunner = CoreConfig.testInstrumentationRunner
        consumerProguardFiles(CoreConfig.consumerRulesFile)
    }

    buildTypes {
        release {
            isMinifyEnabled = CoreConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(CoreConfig.proguardAndroidOptimiseFile),
                CoreConfig.proguardRulesFile
            )
        }
    }
    compileOptions {
        sourceCompatibility = CoreConfig.sourceCompatibility
        targetCompatibility = CoreConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = CoreConfig.jvmTarget
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