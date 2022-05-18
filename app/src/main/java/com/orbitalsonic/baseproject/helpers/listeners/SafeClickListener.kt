package com.orbitalsonic.baseproject.helpers.listeners

import android.os.SystemClock
import android.view.View
import com.orbitalsonic.baseproject.helpers.listeners.OnClickListeners.defaultInterval
import com.orbitalsonic.baseproject.helpers.listeners.OnClickListeners.lastTimeClicked

class SafeClickListener(
    private val onSafeCLick: (View) -> Unit
) : View.OnClickListener {
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
    }
}