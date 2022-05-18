package com.orbitalsonic.baseproject.helpers.utils

import android.content.SharedPreferences

private const val is_splash_interstitial_active = "is_splash_interstitial_active"
private const val priority_exit_native = "priority_exit_native"



class SharedPrefsUtils (private val mSharedPreferences: SharedPreferences){


    var isSplashInterstitialActive: Boolean
        get() = mSharedPreferences.getBoolean(is_splash_interstitial_active, true)
        set(value) {
            mSharedPreferences.edit().apply {
                putBoolean(is_splash_interstitial_active, value)
                apply()
            }
        }

    var priorityExitNative: Int
        get() = mSharedPreferences.getInt(priority_exit_native, 1)
        set(value) {
            mSharedPreferences.edit().apply {
                putInt(priority_exit_native, value)
                apply()
            }
        }

}