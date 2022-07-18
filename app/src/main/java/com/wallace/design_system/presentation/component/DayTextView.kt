package com.wallace.design_system.presentation.component

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.wallace.design_system.R
import com.wallace.design_system.data.storage.*
import com.wallace.design_system.data.utils.DayTextViewConstants.BLUE
import com.wallace.design_system.data.utils.DayTextViewConstants.DARK
import com.wallace.design_system.data.utils.DayTextViewConstants.ERROR
import com.wallace.design_system.data.utils.DayTextViewConstants.LARGE
import com.wallace.design_system.data.utils.DayTextViewConstants.LIGHT
import com.wallace.design_system.data.utils.DayTextViewConstants.MEDIUM
import com.wallace.design_system.data.utils.DayTextViewConstants.SMALL
import com.wallace.design_system.data.utils.DayTextViewConstants.XSMALL
import com.wallace.design_system.data.utils.fromHTMLtoText
import com.wallace.design_system.data.utils.getDensityDpi
import com.wallace.design_system.presentation.component.helper.DSColorHelper
import com.wallace.design_system.presentation.component.helper.DSFontHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("ViewConstructor")
class DayTextView(
    private val fontFamilyDAO: DSFontFamilyDAO,
    val fontWeightDAO: DSFontWeightDAO,
    val colorDAO: DSColorDAO,
    val fontSizeDAO: DSFontSizeDAO,
    val lineHeightDAO: DSLineHeightDAO,
    context: Context,
    attrs: AttributeSet
) : AppCompatTextView(context, attrs), DSFontHelper, DSColorHelper {

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.DayTextView)
        ellipsize = TextUtils.TruncateAt.END
        setFontFamily(attributes.getString(R.styleable.DayTextView_family))
        setWeight(attributes.getString(R.styleable.DayTextView_weight))
        setSize(attributes.getString(R.styleable.DayTextView_size))

        attributes.recycle()
    }

    fun setFontFamily(fontFamily: String?) {
        CoroutineScope(Dispatchers.Default).launch {
            val fontReference = getTypeFace(fontFamilyDAO, fontWeightDAO, fontFamily?.replace("_", "-") ?: "")
            typeface = ResourcesCompat.getFont(context, fontReference)
        }
    }

    fun setWeight(weight: String?) {
        CoroutineScope(Dispatchers.Default).launch {
//            val fontReference = getFontWeight(fontWeightDAO, weight?.replace("_", "-") ?: "")
//            typeface = ResourcesCompat.getFont(context, fontReference)
        }
    }

    fun setSize(size: String?) {
        CoroutineScope(Dispatchers.Default).launch {
            includeFontPadding = false
            val sizeReference = getFontSize(fontSizeDAO, size?.replace("_", "-") ?: "")
            setTextSize(TypedValue.COMPLEX_UNIT_PX, sizeReference)
        }
    }

    fun setHtmlText(textHtml: String) {
        text = textHtml.fromHTMLtoText()
    }

    override suspend fun getFontFamily(fontFamilyDAO: DSFontFamilyDAO, value: String): String? {
        return super.getFontFamily(fontFamilyDAO, value)
    }

    override suspend fun getFontWeight(fontWeightDAO: DSFontWeightDAO, value: String): String? {
        return super.getFontWeight(fontWeightDAO, value)
    }

    override suspend fun getFontSize(fontSizeDAO: DSFontSizeDAO, value: String): Float {
        return super.getFontSize(fontSizeDAO, value)
    }

    override suspend fun getColorPrimary(colorDAO: DSColorDAO, value: String): String? {
        return super.getColorPrimary(colorDAO, value)
    }

    override suspend fun getNeutralColor(colorDAO: DSColorDAO, value: String): String? {
        return super.getNeutralColor(colorDAO, value)
    }

    override suspend fun getTypeFace(
        fontFamilyDAO: DSFontFamilyDAO,
        fontWeightDAO: DSFontWeightDAO,
        value: String
    ): Int {
        return super.getTypeFace(fontFamilyDAO, fontWeightDAO, value)
    }
}