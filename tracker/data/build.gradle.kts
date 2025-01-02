plugins {
    alias(libs.plugins.calorify.android.library)
}

android {
    namespace = "com.shubhans.tracker.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.dagger.hilt)

    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.onboarding.domain)
}