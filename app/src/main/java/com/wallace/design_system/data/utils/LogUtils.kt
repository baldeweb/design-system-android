package com.wallace.design_system.data.utils

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment

object LogUtils {
    private const val TAG_LOG = "LOG"

    fun Activity.logD(text: String) {
        Log.d(TAG_LOG, "[${this.javaClass.simpleName}] - $text")
    }

    fun Fragment.logD(text: String) {
        Log.d(TAG_LOG, "[${this.javaClass.simpleName}] - $text")
    }

    fun logD(text: String) {
        Log.d(TAG_LOG, "[${this.javaClass.simpleName}] - $text")
    }
}