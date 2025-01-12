package com.shubhans.tracker.presentation.tracker_Overview.tracker

import com.shubhans.tracker.domain.model.TrackedFood
import com.shubhans.tracker.presentation.tracker_Overview.components.Meal
import com.shubhans.tracker.presentation.tracker_Overview.components.defaultMeal
import java.time.LocalTime

data class TrackerOverViewState(
    val totalCalories: Int = 0,
    val caloriesGoal: Int = 0,
    val totalCarbs: Int = 0,
    val totalProtein: Int = 0,
    val totalFat: Int = 0,
    val carbsGoal: Int = 0,
    val proteinGoal: Int = 0,
    val fatGoal: Int = 0,
    val date: LocalTime = LocalTime.now(),
    val meals: List<Meal> = defaultMeal,
    val trackedFood: List<TrackedFood> = emptyList()
)