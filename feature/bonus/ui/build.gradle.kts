plugins {
    `android-library`
    `kotlin-android`
}

module(
    name = "feature.bonus.ui",
    Modules(
        projects.feature.product.ui
    )
)