package com.shubhans.onboarding.presentation.di

import com.shubhans.domain.usecases.FitterOutDigit
import com.shubhans.onboarding.domain.use_cases.ValidateNutrients
import com.shubhans.onboarding.presentation.activity.ActivityViewModel
import com.shubhans.onboarding.presentation.age.AgeScreenViewModel
import com.shubhans.onboarding.presentation.gender.GenderScreenViewModel
import com.shubhans.onboarding.presentation.goal.GoalViewModel
import com.shubhans.onboarding.presentation.height.HeightViewModel
import com.shubhans.onboarding.presentation.nutrient.NutrientViewModel
import com.shubhans.onboarding.presentation.weight.WeightViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val onboardingPresentationModule = module {
    single { ValidateNutrients() }
    single { FitterOutDigit() }

    viewModel { GenderScreenViewModel(get())}
    viewModel { AgeScreenViewModel(get(), get()) }
    viewModel { ActivityViewModel(get()) }
    viewModel { GoalViewModel(get()) }
    viewModel { HeightViewModel(get(), get()) }
    viewModel { NutrientViewModel(get(), get(), get()) }
    viewModel { WeightViewModel(get()) }
}