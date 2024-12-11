pluginManagement {
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

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "navigation-template"
include(":app")

include(":feature:base:data")
include(":feature:base:domain")
include(":feature:base:presentation")
include(":feature:base:ui")

include(":feature:home:presentation")
include(":feature:home:ui")

include(":feature:bonus:domain")
include(":feature:bonus:presentation")
include(":feature:bonus:ui")

include(":feature:product:domain")
include(":feature:product:presentation")
include(":feature:product:ui")

include(":feature:cooking:presentation")

include(":feature:mylist:presentation")
