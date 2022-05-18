package com.orbitalsonic.baseproject

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatDelegate
import com.orbitalsonic.baseproject.helpers.utils.InternetHandler
import com.orbitalsonic.baseproject.helpers.utils.SharedPrefsUtils
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication:Application() {

    companion object {
        var applicationInstance: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        applicationInstance = applicationContext

        startKoin{
            androidContext(this@MainApplication)
            modules(listOf(appModule))
        }
    }

    private val appModule = module{

        single { SharedPrefsUtils(getSharedPreferences("AppSharedPrefs", MODE_PRIVATE)) }
        single { InternetHandler( getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager) }
    }

//    private val viewModelModule = module{
//        single { HomeViewModel() }
//    }

//
//    private val dbModule = module {
//        single { database.translatorDao() }
//
//        single { TranslatorRepository(get()) }
//
//        single { TranslatorViewModel(get()) }
//    }

}