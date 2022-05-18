package com.orbitalsonic.baseproject.helpers.utils

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

object ExtensionFunctions {
    fun Fragment.findNavControllerSafely(): NavController? {
        return if (isAdded) {
            findNavController()
        } else {
            null
        }
    }

    fun String.allCapsFalse():String{
       return this.lowercase()
    }
}