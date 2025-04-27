plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = NetworkConfig.nameSpace
    compileSdk = NetworkConfig.compileSdk

    defaultConfig {
        minSdk = NetworkConfig.minSdk

        testInstrumentationRunner = NetworkConfig.testInstrumentationRunner
        consumerProguardFiles(NetworkConfig.consumerRulesFile)
    }

    buildTypes {
        release {
            isMinifyEnabled = NetworkConfig.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(NetworkConfig.proguardAndroidOptimiseFile),
                NetworkConfig.proguardRulesFile
            )
        }
    }
    compileOptions {
        sourceCompatibility = NetworkConfig.sourceCompatibility
        targetCompatibility = NetworkConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = NetworkConfig.jvmTarget
    }
}

dependencies {

    // Modules
    implementation(project(Modules.CORE))

    // Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Kotlinx Serialization
    implementation(libs.kotlinx.serialization.json)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}