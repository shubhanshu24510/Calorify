package com.shubhans.calorify.di

import android.content.SharedPreferences
import com.shubhans.calorify.CalorifyApp
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
//    single<SharedPreferences> {
//        EncryptedSharedPreferences(
//            androidApplication(),
//            "auth_pref",
//            MasterKey(androidApplication()),
//            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//        )
//    }
    single<CoroutineScope> {
        (androidApplication() as CalorifyApp).applicationScope
    }
}
