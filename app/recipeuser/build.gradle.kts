plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose) // NB: Add this
    alias(libs.plugins.dagger.hilt ) apply false
}

android {
    namespace = "com.safiribytes.recipeuser"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.safiribytes.recipeuser"
        minSdk = 31
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    //NB: Add this line here
    buildFeatures {
        compose = true
    }
}

/*
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
*/

dependencies {

 /*   implementation(project(":features"))
    implementation(project(":features:authentication"))
    implementation(project(":features:dashboard"))
    implementation(project(":core"))
    implementation(project(":coreui"))
    implementation(project(":features:landing"))*/

    implementation(project(":coreui"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.composer.runtime)

    //images coil
    implementation(libs.coil.compose)
    //pager
    implementation(libs.accompanistpager)
    implementation(libs.accompanistpager.indicator)

    //Splash Screen
    implementation(libs.core.splashscreen )

    //ktor
    implementation(libs.ktor.serializer)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.auth)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.network)
    implementation(libs.ktor.mock)
    implementation(libs.ktor.network.tls)
    //hilt
    implementation(libs.hilt.navigation.compose )
    implementation(libs.dagger.hilt.impl )
    implementation(libs.dagger.hilt.comp  )
    //coroutines
    implementation(libs.coroutines )
}