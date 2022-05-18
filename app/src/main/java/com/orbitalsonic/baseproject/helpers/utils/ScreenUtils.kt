package com.orbitalsonic.baseproject.helpers.utils

import android.app.Activity
import android.util.DisplayMetrics
import com.orbitalsonic.baseproject.helpers.firebase.FirebaseUtils.recordException

object ScreenUtils {

    private val tagScreen:String = "screenTag"


    fun Activity?.getScreenWidth(): Int {

        val outMetrics = DisplayMetrics()

        this?.let {
            try {
                return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                    val display = it.display
                    display?.getRealMetrics(outMetrics)
                    outMetrics.widthPixels
                } else {
                    @Suppress("DEPRECATION")
                    val display = it.windowManager.defaultDisplay
                    @Suppress("DEPRECATION")
                    display.getMetrics(outMetrics)

                    outMetrics.widthPixels
                }
            }catch (e:Exception){
                e.recordException(tagScreen)
                return 300
            }

        }?:run{
            return 300
        }




    }

    fun Activity?.getScreenHeight(): Int {
        val outMetrics = DisplayMetrics()

        this?.let {
            try {
                return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                    val display = it.display
                    display?.getRealMetrics(outMetrics)
                    outMetrics.heightPixels
                } else {
                    @Suppress("DEPRECATION")
                    val display = it.windowManager.defaultDisplay
                    @Suppress("DEPRECATION")
                    display.getMetrics(outMetrics)

                    outMetrics.heightPixels
                }
            }catch (e:Exception){
                e.recordException(tagScreen)
                return 500
            }

        }?:run{
            return 500
        }


    }
}