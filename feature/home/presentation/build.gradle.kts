plugins {
    `android-library`
    `kotlin-android`
}

module(
    name = "feature.home.presentation",
    modules = projects.feature.run {
        Modules(
            home.ui,
            bonus.domain,
            bonus.ui,
            product.ui,
            product.domain,
            product.presentation,
        )
    }
)