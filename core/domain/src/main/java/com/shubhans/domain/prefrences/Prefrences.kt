package com.shubhans.domain.prefrences

import com.shubhans.domain.model.ActivityLevel
import com.shubhans.domain.model.Gender
import com.shubhans.domain.model.GoalType
import com.shubhans.domain.model.UserInfo

interface Prefrences {
    fun saveGender(gender: Gender)
    fun saveAge(age: Int)
    fun saveHeight(height: Int)
    fun saveWeight(weight: Float)
    fun saveActivityLevel(activityLevel: ActivityLevel)
    fun saveGoal(goalType: GoalType)
    fun saveCarbsRatio(carbsRatio: Float)
    fun saveProteinsRatio(proteinsRatio: Float)
    fun saveFatsRatio(fatsRatio: Float)

    fun saveUserInfo(userInfo: UserInfo)

    fun saveOnboardingCompleted(shouldShow : Boolean)
    fun shouldShowOnboarding(): Boolean
}