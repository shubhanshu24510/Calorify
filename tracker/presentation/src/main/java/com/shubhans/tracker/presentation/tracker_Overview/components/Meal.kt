package com.shubhans.tracker.presentation.tracker_Overview.components

import androidx.annotation.DrawableRes
import com.shubhans.core.presentation.utils.UiText
import com.shubhans.tracker.domain.model.MealType
import com.shubhans.tracker.presentation.R

data class Meal(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val calories: Int = 0,
    val carbs: Int = 0,
    val protein: Int = 0,
    val fat: Int = 0,
    val expandable: Boolean = false
)

val defaultMeal = listOf(
    Meal(
        name = UiText.StringResource(R.string.breakfast),
        drawableRes = R.drawable.ic_breakfast,
        mealType = MealType.BREAKFAST,
    ), Meal(
        name = UiText.StringResource(R.string.lunch),
        drawableRes = R.drawable.ic_lunch,
        mealType = MealType.LUNCH,
    ), Meal(
        name = UiText.StringResource(R.string.dinner),
        drawableRes = R.drawable.ic_dinner,
        mealType = MealType.DINNER,
    ), Meal(
        name = UiText.StringResource(R.string.snack),
        drawableRes = R.drawable.ic_snack,
        mealType = MealType.SNACK,
    )
)
