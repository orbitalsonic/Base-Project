package com.orbitalsonic.baseproject.helpers.firebase

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.ktx.Firebase
import com.orbitalsonic.baseproject.helpers.utils.ALog


object FirebaseUtils {

    const val TAG_FIREBASE = "firebase_tag"
    fun Throwable.recordException(log:String){
        try {
            FirebaseCrashlytics.getInstance().log(log)
            FirebaseCrashlytics.getInstance().recordException(this)
            ALog.e(TAG_FIREBASE,this.message.toString())

        }catch (e:Exception){
            ALog.e(TAG_FIREBASE,e.message.toString())
        }
    }

    fun String.postEvent() {
        try {
            val firebaseAnalytics: FirebaseAnalytics = Firebase.analytics
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                param(FirebaseAnalytics.Param.SCREEN_NAME, this@postEvent.lowercase())
            }

        } catch (ex: Exception) {
            try {
                FirebaseCrashlytics.getInstance().log("post_event_crash")
                FirebaseCrashlytics.getInstance().recordException(ex)

            }catch (e:Exception){
                ALog.e(TAG_FIREBASE,e.message.toString())
            }
        }

    }

}