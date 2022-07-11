package com.wallace.design_system.data.utils

import android.content.Context
import android.text.Spanned
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager
import androidx.core.text.HtmlCompat

fun String.fromHTMLtoText(): Spanned {
    return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_COMPACT)
}
fun Context.getDensityDpi(): Int {
    val wm = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display: Display = wm.defaultDisplay
    val metrics = DisplayMetrics()
    display.getMetrics(metrics)
    return metrics.densityDpi
}