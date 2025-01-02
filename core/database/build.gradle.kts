plugins {
    alias(libs.plugins.calorify.android.library)
    alias(libs.plugins.calorify.android.room)
}

android {
    namespace = "com.shubhans.core.database"
}

dependencies {

    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
}