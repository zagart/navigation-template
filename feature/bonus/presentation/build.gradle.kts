plugins {
    `android-library`
    `kotlin-android`
}

module(
    name = "feature.bonus.presentation",
    modules = Modules(
        projects.feature.bonus.ui,
        projects.feature.product.presentation
    )
)