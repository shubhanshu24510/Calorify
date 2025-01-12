package com.shubhans.tracker.domain.model

import java.time.LocalDate

data class TrackedFood(
    val id: Int? = null,
    val name: String,
    val imageUrl: String?,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val mealType: MealType,
    val calories: Int,
    val amount: Int,
    val date: LocalDate = LocalDate.now()
)
