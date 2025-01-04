package com.shubhans.data

import android.content.SharedPreferences
import com.shubhans.domain.model.ActivityLevel
import com.shubhans.domain.model.Gender
import com.shubhans.domain.model.GoalType
import com.shubhans.domain.model.UserInfo
import com.shubhans.domain.prefrences.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
) : Preferences {
    override fun saveGender(gender: Gender) {
        sharedPref.edit()
            .putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPref.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.name)
            .apply()
    }

    override fun saveGoal(goalType: GoalType) {
        sharedPref.edit()
            .putString(Preferences.KEY_GOAL_TYPE, goalType.name)
            .apply()
    }

    override fun saveCarbsRatio(carbsRatio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_CARB_RATIO, carbsRatio)
            .apply()
    }

    override fun saveProteinsRatio(proteinsRatio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO, proteinsRatio)
            .apply()
    }

    override fun saveFatsRatio(fatsRatio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_FAT_RATIO, fatsRatio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderSting = sharedPref.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbsRatio = sharedPref.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinsRatio = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatsRatio = sharedPref.getFloat(Preferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(genderSting ?: "male"),
            age = age,
            height = height,
            weight = weight,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goal = GoalType.fromString(goalType ?: "keep_weight"),
            carbsRatio = carbsRatio,
            proteinsRatio = proteinsRatio,
            fatsRatio = fatsRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING, shouldShow)
            .apply()
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPref
            .getBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING, true)
    }

}