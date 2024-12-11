plugins {
    `android-library`
    `kotlin-android`
}

module(
    name = "feature.bonus.presentation",
    modules = projects.feature.run {
        Modules(
            bonus.domain,
            bonus.ui,
            product.domain,
            product.ui,
        )
    }
)