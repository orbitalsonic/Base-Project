package com.orbitalsonic.baseproject.helpers.utils

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.orbitalsonic.baseproject.helpers.firebase.FirebaseUtils.recordException

class InternetHandler(private val connectivityManager: ConnectivityManager) {
    private val tagInternet:String = "internetTag"
    val isInternetConnected: Boolean
        get() {
            try {
                val nw = connectivityManager.activeNetwork ?: return false
                val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
                return when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } catch (e: Exception) {
                e.recordException(tagInternet)
            }
            return false
        }
}