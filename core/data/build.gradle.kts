plugins {
    alias(libs.plugins.calorify.android.library)
    alias(libs.plugins.calorify.jvm.retrofit)
}

android {
    namespace = "com.shubhans.data"
}

dependencies {
    implementation(libs.bundles.dagger.hilt)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}