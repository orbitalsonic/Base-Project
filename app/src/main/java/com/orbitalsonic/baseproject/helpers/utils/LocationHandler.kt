package com.orbitalsonic.baseproject.helpers.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.orbitalsonic.baseproject.helpers.firebase.FirebaseUtils.recordException

object LocationHandler {
    private val tagLocation:String = "locationTag"

    fun Activity?.isLocationApproved():Boolean{
        this?.let {
            try {
                return PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } catch (e: Exception) {
                e.recordException(tagLocation)
                return false
            }

        }?: run {
            return false
        }

    }
}