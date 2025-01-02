plugins {
    alias(libs.plugins.calorify.android.library)
    alias(libs.plugins.calorify.android.room)
}

android {
    namespace = "com.shubhans.core.database"
}

dependencies {
    implementation(libs.bundles.dagger.hilt)

    implementation(projects.core.domain)
}