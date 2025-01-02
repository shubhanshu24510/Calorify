package com.shubhans.domain.model

sealed class ActivityLevel(val name : String) {
    object Low: Gender("low")
    object Medium: Gender("medium")
    object High: Gender("high")

    companion object {
        fun fromString(name: String): Gender {
            return when(name) {
                "low" -> Low
                "medium" -> Medium
                "high" -> High
                else -> Medium
            }
        }
    }
}