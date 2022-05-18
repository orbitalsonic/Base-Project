package com.orbitalsonic.baseproject.helpers.utils

import android.app.Activity
import android.app.SearchManager
import android.content.*
import android.net.Uri
import com.orbitalsonic.baseproject.R
import com.orbitalsonic.baseproject.helpers.firebase.FirebaseUtils.recordException
import com.orbitalsonic.baseproject.helpers.utils.ALog.showToast


object GeneralUtils {

    private val generalTag = "generalTag"

    fun Activity?.openPlayStoreApp(packageName:String) {
        this?.let {
            try {
                it.startActivity(
                    Intent(
                        "android.intent.action.VIEW",
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }catch (e:Exception){
                e.recordException(generalTag)
            }
        }

    }

    fun Activity?.rateUs() {
        this?.let {
            try {
                it.startActivity(
                    Intent(
                        "android.intent.action.VIEW",
                        Uri.parse("https://play.google.com/store/apps/details?id=" + it.packageName)
                    )
                )
            }catch (e:Exception){
                e.recordException(generalTag)
            }
        }

    }

    fun Activity?.aboutUs() {
        this?.let {
            try {
                it.startActivity(
                    Intent(
                        "android.intent.action.VIEW",
                        Uri.parse(it.getString(R.string.about_link))
                    )
                )
            }catch (e:Exception){
                e.recordException(generalTag)
            }
        }

    }

    fun Activity?.privacyPolicy() {
        this?.let {
            try {
                it.startActivity(
                    Intent(
                        "android.intent.action.VIEW",
                        Uri.parse(it.getString(R.string.privacy_link))
                    )
                )
            }catch (e:Exception){
                generalTag
            }
        }

    }

    fun Activity?.feedback() {

        this?.let {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "message/rfc822"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(it.getString(R.string.app_email)))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, it.getString(R.string.app_name))
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Feedback...")
            try {
                it.startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                ex.recordException(generalTag)
                it.showToast("There are no email clients installed.")
            }
        }

    }


    fun Activity?.shareApp() {
        this?.let {
            try {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, it.getString(R.string.app_name))
                sendIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "https://play.google.com/store/apps/details?id=${it.packageName}"
                )
                sendIntent.type = "text/plain"
                it.startActivity(sendIntent)
            }catch (e:Exception){
                e.recordException(generalTag)
            }

        }

    }

    fun Activity?.copyClipboardData(mData:String){
        this?.let {
            try {
                val clipboard = it.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip: ClipData = ClipData.newPlainText(
                    "simple text",
                    mData
                )
                clipboard.setPrimaryClip(clip)
            }catch (e:Exception){
                e.recordException(generalTag)
            }
        }

    }

    fun Activity?.shareTextData(mData: String){
        this?.let {
            try {
                val mIntent = Intent(Intent.ACTION_SEND)
                mIntent.type = "text/plain"
                mIntent.putExtra(Intent.EXTRA_SUBJECT, "Data")
                mIntent.putExtra(Intent.EXTRA_TEXT, mData)
                it.startActivity(Intent.createChooser(mIntent, "Choose to share"))
            }catch (e:Exception){
                e.recordException(generalTag)
            }
        }

    }

    fun Activity?.searchData(mData: String) {
        this?.let {
           try {
               val mIntent = Intent(Intent.ACTION_WEB_SEARCH)
               mIntent.putExtra(SearchManager.QUERY, mData)
               it.startActivity(mIntent)
           } catch (e:Exception){
               e.recordException(generalTag)
           }
        }

    }

    fun Activity?.translateDate(mData: String) {
        this?.let {
            try {
                val url =
                    "https://translate.google.com/#view=home&op=translate&sl=auto&tl=en&text=$mData"
                val mIntent = Intent(Intent.ACTION_VIEW)
                mIntent.data = Uri.parse(url)
                it.startActivity(mIntent)
            }catch (e:Exception){
                e.recordException(generalTag)
            }
        }


    }

}