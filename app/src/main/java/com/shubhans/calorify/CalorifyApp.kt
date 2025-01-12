package com.shubhans.calorify

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import com.shubhans.calorify.di.appModule
import com.shubhans.data.di.coreDataModule
import com.shubhans.onboarding.presentation.di.onboardingPresentationModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CalorifyApp : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CalorifyApp)
            modules(
                appModule,
                onboardingPresentationModule,
                coreDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}
