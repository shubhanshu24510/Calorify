package com.shubhans.tracker.domain.model

sealed class MealType(val name: String) {
    object BREAKFAST : MealType("breakfast")
    object LUNCH : MealType("lunch")
    object DINNER : MealType("dinner")
    object SNACK : MealType("snack")

    companion object {
        fun fromString(name: String): MealType {
            return when (name) {
                "breakfast" -> BREAKFAST
                "lunch" -> LUNCH
                "dinner" -> DINNER
                "snack" -> SNACK
                else -> BREAKFAST
            }
        }
    }
}