plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.kachiro.gametrackerapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kachiro.gametrackerapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.navigation.test)
    androidTestImplementation(libs.androidx.fragment.test)

    implementation(project(":core-factory"))
    implementation(project(":uikit"))
    implementation(project(":base"))

    implementation(project(":game"))
    implementation(project(":home"))
    implementation(project(":main"))
    implementation(project(":game-detail"))
    implementation(project(":game-catalog"))
    implementation(project(":imageViewer"))
    implementation(libs.dagger.android)
    implementation(libs.cicerone.navigation)
    kapt(libs.dagger.compiler)
}