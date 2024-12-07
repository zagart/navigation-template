import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

open class LibraryGradlePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply("android-library")
            pluginManager.apply("kotlin-android")
            pluginManager.apply("kotlin-parcelize")
            pluginManager.apply("com.google.devtools.ksp")

            setupHilt()

            with(android()) {
                compileSdk = ProjectConfig.compileSdkVersion

                defaultConfig.apply {
                    minSdk = ProjectConfig.minSdkVersion
                    targetSdk = ProjectConfig.targetSdkVersion
                    versionCode = ProjectConfig.versionCode
                    versionName = ProjectConfig.versionName

                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }
                buildTypes {
                    debug {
                        isMinifyEnabled = false
                    }
                }
                buildFeatures {
                    compose = true
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = ProjectConfig.kotlinCompilerExtensionVersion
                }
                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }
        }
    }
}