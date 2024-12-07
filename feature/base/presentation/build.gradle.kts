plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.kotlin.serialization)
}

module(
    name = "feature.base.presentation"
)