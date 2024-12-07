plugins {
    `android-library`
    `kotlin-android`
}

module(
    name = "feature.product.presentation",
    modules = Modules(
        projects.feature.product.ui,
    )
)