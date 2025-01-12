package com.shubhans.tracker.presentation.tracker_Overview.tracker

import com.shubhans.tracker.domain.model.TrackedFood
import com.shubhans.tracker.presentation.tracker_Overview.components.Meal

sealed class TrackerOverviewAction {
    object onNextDayClick : TrackerOverviewAction()
    object onPreviousDayClick : TrackerOverviewAction()
    data class onMealToggleClick(val meal: Meal) : TrackerOverviewAction()
    data class onTrackedFoodDeleteClick(val trackedFood: TrackedFood) : TrackerOverviewAction()
}