package com.orbitalsonic.baseproject.helpers.di

import com.orbitalsonic.baseproject.helpers.utils.InternetHandler
import com.orbitalsonic.baseproject.helpers.utils.SharedPrefsUtils
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DIComponent: KoinComponent {

//    val sharedPrefsUtils:SharedPrefsUtils = get()
    val sharedPrefsUtils: SharedPrefsUtils by inject()
    val internetHandler: InternetHandler by inject()

}