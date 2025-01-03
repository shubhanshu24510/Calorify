package com.shubhans.domain.model

sealed class GoalType(val name : String) {
    object Lose: GoalType("lose")
    object Keep: GoalType("keep")
    object Gain: GoalType("gain")

    companion object {
        fun fromString(name: String): GoalType {
            return when(name) {
                "lose" -> Lose
                "keep" -> Keep
                "gain" -> Gain
                else -> Keep
            }
        }
    }
}