package com.shubhans.data.di

import com.shubhans.data.DefaultPreferences
import com.shubhans.domain.prefrences.Preferences
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    singleOf(::DefaultPreferences).bind<Preferences>()
}