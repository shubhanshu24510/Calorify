plugins {
    alias(libs.plugins.calorify.android.application.compose)
    alias(libs.plugins.calorify.jvm.retrofit)
}

android {
    namespace = "com.shubhans.calorify"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {
    // Coil
    implementation(libs.coil.compose)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)

    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Splash screen
    implementation(libs.androidx.core.splashscreen)

    //KOIN
    implementation(libs.bundles.koin)

    // Google Play services
    api(libs.play.feature.delivery)
    api(libs.play.feature.delivery.ktx)

    // Crypto
    implementation(libs.androidx.security.crypto.ktx)

    //timber
    implementation(libs.timber)

    // Core
    implementation(projects.core.presentation.ui)
    implementation(projects.core.presentation.designsystem)
    implementation(projects.core.domain)
    implementation(projects.core.data)

    // Tracker
    implementation(projects.tracker.presentation)
    implementation(projects.tracker.domain)
    implementation(projects.tracker.data)

    // Onboarding
    implementation(projects.onboarding.presentation)
    implementation(projects.onboarding.domain)
}