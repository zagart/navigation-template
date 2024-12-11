plugins {
    `android-library`
    `kotlin-android`
}

module(
    name = "feature.bonus.domain",
    Modules(
        projects.feature.product.domain
    )
)