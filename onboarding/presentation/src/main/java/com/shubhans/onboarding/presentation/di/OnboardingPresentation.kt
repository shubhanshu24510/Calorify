package com.shubhans.onboarding.presentation.di

import com.shubhans.onboarding.presentation.activity.ActivityViewModel
import com.shubhans.onboarding.presentation.age.AgeScreenViewModel
import com.shubhans.onboarding.presentation.gender.GenderScreenViewModel
import com.shubhans.onboarding.presentation.goal.GoalViewModel
import com.shubhans.onboarding.presentation.height.HeightViewModel
import com.shubhans.onboarding.presentation.nutrient.NutrientViewModel
import com.shubhans.onboarding.presentation.weight.WeightViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val onboardingPresentationModule = module {
    viewModelOf(::ActivityViewModel)
    viewModelOf(::AgeScreenViewModel)
    viewModelOf(::GenderScreenViewModel)
    viewModelOf(::GoalViewModel)
    viewModelOf(::HeightViewModel)
    viewModelOf(::NutrientViewModel)
    viewModelOf(::WeightViewModel)
}