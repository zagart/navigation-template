plugins {
    `android-library`
    `kotlin-android`
}

module(
    name = "feature.base.ui",
    dependencies = Dependencies(
        libs.material.icons.extended
    )
)