package com.orbitalsonic.baseproject.helpers.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast

object ALog {
    const val TAG_GENERAL = "general_tag"
    fun d(tag: String, msg: String) {
            Log.d(tag, msg)
        }

    fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }

    fun i(tag: String, msg: String) {
        Log.i(tag, msg)
    }

    fun v(tag: String, msg: String) {
        Log.v(tag, msg)
    }

    fun w(tag: String, msg: String) {
        Log.w(tag, msg)
    }

    fun logAndToast(context: Context?,tag:String, message: String){
        context?.let {
            try {
                Toast.makeText(it,message, Toast.LENGTH_SHORT).show()
                d(tag,message)
            }catch (e:Exception){
                e(tag,e.message.toString())
            }
        }

    }

    fun showToast(context: Context?,message: String){
        context?.let {
            try {
                Toast.makeText(it,message, Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                e(TAG_GENERAL,e.message.toString())
            }
        }

    }


    fun Activity?.logAndToast(tag:String, message: String){
        this?.let {
            try {
                it.runOnUiThread {
                    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
                    d(tag,message)
                }

            }catch (e:Exception){
                e(tag,e.message.toString())
            }

        }

    }

    fun Activity?.showToast(message: String){
        this?.let {
            try {
                it.runOnUiThread{
                    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
                }

            }catch (e:Exception){
                e(TAG_GENERAL,e.message.toString())
            }

        }

    }

}