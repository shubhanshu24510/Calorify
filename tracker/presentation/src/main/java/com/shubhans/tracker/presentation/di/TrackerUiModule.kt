package com.shubhans.tracker.presentation.di

import com.shubhans.tracker.presentation.tracker_Overview.tracker.TrackerOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val trackerUiModule = module {
    viewModelOf(::TrackerOverviewViewModel)
}