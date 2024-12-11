plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.kotlin.serialization)
}

module(
    name = "feature.base.presentation",
    modules = projects.feature.run {
        Modules(
            bonus.ui,
            product.ui,
        )
    }
)