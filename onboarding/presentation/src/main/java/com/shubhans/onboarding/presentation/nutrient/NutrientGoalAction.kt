package com.shubhans.onboarding.presentation.nutrient

sealed class NutrientGoalAction {
    data class enterCarbonRatio(val ratio: String) : NutrientGoalAction()
    data class enterProteinRatio(val ratio: String) : NutrientGoalAction()
    data class enterFatRatio(val ratio: String) : NutrientGoalAction()
    data object OnNextClick : NutrientGoalAction()
}