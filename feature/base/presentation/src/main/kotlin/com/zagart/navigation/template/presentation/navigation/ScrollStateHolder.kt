package com.zagart.navigation.template.presentation.navigation

import android.os.Parcelable
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.parcelize.Parcelize

class ScrollStateHolder {

    private val states: MutableMap<String, ParcelableLazyListState> = mutableMapOf()

    @Composable
    fun getListState(destination: Destination): LazyListState {
        // Separate scroll states for same destinations in different backstacks
        val key = destination::class.simpleName + destination.args.backstackIndex

        val savedState = rememberSaveable(key, saver = ParcelableLazyListState.Saver) {
            states[key]?.toLazyListState() ?: LazyListState()
        }

        states[key] = ParcelableLazyListState.from(savedState)

        return savedState
    }

    @Parcelize
    private data class ParcelableLazyListState(
        val firstVisibleItemIndex: Int,
        val firstVisibleItemScrollOffset: Int
    ) : Parcelable {

        fun toLazyListState() = LazyListState(
            firstVisibleItemIndex = firstVisibleItemIndex,
            firstVisibleItemScrollOffset = firstVisibleItemScrollOffset
        )

        companion object {
            fun from(state: LazyListState): ParcelableLazyListState {
                return ParcelableLazyListState(
                    firstVisibleItemIndex = state.firstVisibleItemIndex,
                    firstVisibleItemScrollOffset = state.firstVisibleItemScrollOffset
                )
            }

            val Saver = Saver<LazyListState, ParcelableLazyListState>(
                save = { from(it) },
                restore = { it.toLazyListState() }
            )
        }
    }
}