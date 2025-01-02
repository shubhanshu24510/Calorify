package com.shubhans.domain.model

sealed class GoalType(val name : String) {
    object Lose: Gender("lose")
    object Keep: Gender("keep")
    object Gain: Gender("gain")

    companion object {
        fun fromString(name: String): Gender {
            return when(name) {
                "lose" -> Lose
                "keep" -> Keep
                "gain" -> Gain
                else -> Keep
            }
        }
    }
}