package com.orbitalsonic.baseproject.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orbitalsonic.baseproject.helpers.di.DIComponent

open class BaseActivity: AppCompatActivity() {

    val diComponent = DIComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}