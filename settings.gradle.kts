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

rootProject.name = "RecipeAndroid"
include(":app")
include(":app:recipeuser")
include(":app:recipechef")
include(":features")
include(":features:authentication")
include(":features:dashboard")
include(":core")
include(":coreui")
include(":features:landing")
