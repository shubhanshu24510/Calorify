plugins {
    alias(libs.plugins.calorify.android.feature.ui)
}

android {
    namespace = "com.shubhans.onboarding.presentation"

}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.onboarding.domain)
    implementation(projects.core.presentation.designsystem)
    implementation(projects.core.presentation.ui)
}