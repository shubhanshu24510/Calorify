plugins {
    alias(libs.plugins.calorify.android.feature.ui)
}

android {
    namespace = "com.shubhans.tracker.presentation"
}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.tracker.domain)
}