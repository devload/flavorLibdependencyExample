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
        maven {
            url = uri("http://localhost:8081/repository/maven-releases/")
            isAllowInsecureProtocol = true
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "flavorExample"
include(":app")
include(":animal")
include(":Dog")
include(":Cat")
