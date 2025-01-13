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

rootProject.name = "gameTrackerApp"
include(":app")
include(":core-api")
include(":core-impl")
include(":core-factory")

include(":main")
include(":home")
include(":game")
include(":game-api")
include(":base")
include(":home-api")
include(":uikit")
include(":game-detail")
include(":game-detail-api")
include(":game-catalog")
include(":game-catalog-api")
