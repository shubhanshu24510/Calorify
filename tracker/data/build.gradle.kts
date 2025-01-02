plugins {
    alias(libs.plugins.calorify.android.library)
}

android {
    namespace = "com.shubhans.tracker.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.onboarding.domain)
}