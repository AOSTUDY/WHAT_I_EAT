plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization") version Versions.kotlinVersion
    id("org.jlleitschuh.gradle.ktlint")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}

android {
    compileSdk = Constants.compileSdk
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = Constants.packageName
        minSdk = Constants.minSdk
        targetSdk = Constants.targetSdk
        versionCode = Constants.versionCode
        versionName = Constants.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlinOptions {
        val options = this
        options.jvmTarget = Versions.jvmVersion
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    // Android Core
    implementation(KotlinDependencies.kotlin)
    implementation(AndroidXDependencies.coreKtx)
    implementation(AndroidXDependencies.appCompat)
    implementation(AndroidXDependencies.constraintLayout)
    implementation(AndroidXDependencies.coroutines)

    // Material Design
    implementation(MaterialDesignDependencies.materialDesign)

    // Dagger-Hilt
    implementation(AndroidXDependencies.hilt)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(KaptDependencies.hiltCompiler)

    // Jetpack Navigation Component
    implementation(AndroidXDependencies.navigationFragment)
    implementation(AndroidXDependencies.navigationUI)

    // Jetpack Fragment
    implementation(AndroidXDependencies.fragment)

    // Jetpack Lifecycle
    implementation(AndroidXDependencies.coroutines)
    implementation(AndroidXDependencies.lifeCycleKtx)
    implementation(AndroidXDependencies.lifecycleJava8)

    // ImageLoading Library
    // Glide for general
    implementation(ThirdPartyDependencies.glide)
    kapt(KaptDependencies.glideCompiler)

    // Http Client Library
    implementation(ThirdPartyDependencies.retrofit)
    implementation(platform(ThirdPartyDependencies.okHttpBom))
    implementation(ThirdPartyDependencies.okHttp)
    implementation(ThirdPartyDependencies.okHttpLoggingInterceptor)
    implementation(ThirdPartyDependencies.kotlinxSerializationConverter)

    // Automatic Record OpenSource Library List
    implementation(ThirdPartyDependencies.ossLicense)

    // kotlinx-serialization-json
    implementation(ThirdPartyDependencies.kotlinxSerializationJsonConverter)

    // Test Dependency
    testImplementation(TestDependencies.androidTest)
    testImplementation(TestDependencies.jUnit)
    testImplementation(TestDependencies.espresso)
}

ktlint {
    android.set(true)
    coloredOutput.set(true)
    verbose.set(true)
    outputToConsole.set(true)
}
