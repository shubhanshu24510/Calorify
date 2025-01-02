package com.shubhans.domain.model

data class UserInfo(
    val gender: Gender,
    val age: Int,
    val height: Int,
    val weight: Float,
    val activityLevel: ActivityLevel,
    val goal: GoalType,
    val carbsRatio: Float,
    val proteinsRatio: Float,
    val fatsRatio: Float
)
