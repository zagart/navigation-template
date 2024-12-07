plugins {
    `android-library`
    `kotlin-android`
}

module(
    name = "feature.home.ui",
    modules = Modules(
        projects.feature.bonus.ui,
        projects.feature.product.ui,
    )
)