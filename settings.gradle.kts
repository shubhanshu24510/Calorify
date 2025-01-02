pluginManagement {
    includeBuild("build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))

rootProject.name = "Calorify"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core")
include(":core:data")
include(":core:domain")
include(":tracker:data")
include(":tracker:presentation")
include(":tracker:domain")
include(":onboarding:presentation")
include(":onboarding:domain")
include(":core:database")
include(":core:presentation:ui")
include(":core:presentation:designsystem")
