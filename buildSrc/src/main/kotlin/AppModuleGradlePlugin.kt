import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AppModuleGradlePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply("com.google.devtools.ksp")
            setupHilt()
            setupCompose()
            setupRoom()
            dependencies {
                implementation(library("serialization-json"))
                modules()
            }
        }
    }
}