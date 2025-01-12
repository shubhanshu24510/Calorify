package com.shubhans.tracker.presentation.tracker_Overview.tracker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.domain.prefrences.Preferences
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class TrackerOverviewViewModel(
    private  val preferences: Preferences
): ViewModel() {
    var state by mutableStateOf(TrackerOverViewState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: TrackerOverviewAction) {
        when (action) {
            is TrackerOverviewAction.onMealToggleClick -> TODO()
            TrackerOverviewAction.onNextDayClick -> TODO()
            TrackerOverviewAction.onPreviousDayClick -> TODO()
            is TrackerOverviewAction.onTrackedFoodDeleteClick -> TODO()
        }
    }
}