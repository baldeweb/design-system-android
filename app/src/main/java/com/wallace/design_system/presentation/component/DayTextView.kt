package com.wallace.design_system.presentation.component

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
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
        setAppearance(attributes.getString(R.styleable.DayTextView_appearance))
        setSize(attributes.getString(R.styleable.DayTextView_size))

        attributes.recycle()
    }

    fun setAppearance(style: String?) {
        when (style) {
            LIGHT -> {
                typeface = ResourcesCompat.getFont(context, R.font.mulish_regular)
                //setTextColor(ContextCompat.getColor(context, R.color.light_gray))
            }
            DARK -> {
                typeface = ResourcesCompat.getFont(context, R.font.mulish_bold)
                //setTextColor(ContextCompat.getColor(context, R.color.light_gray))
            }
            BLUE -> {
                typeface = ResourcesCompat.getFont(context, R.font.mulish_black)
                //setTextColor(ContextCompat.getColor(context, R.color.light_gray))
            }
            ERROR -> {
                typeface = ResourcesCompat.getFont(context, R.font.mulish_regular)
                //setTextColor(ContextCompat.getColor(context, R.color.light_gray))
            }
            else -> {
                typeface = ResourcesCompat.getFont(context, R.font.mulish_bold)
                //setTextColor(ContextCompat.getColor(context, R.color.black))
            }
        }
    }

    fun setSize(size: String?) {
        includeFontPadding = false

        when (size) {
            XSMALL -> {
//                setTextSize(
//                    TypedValue.COMPLEX_UNIT_PX,
//                    resources.getDimension(R.dimen.text_xsmall)
//                )
            }
            SMALL -> {
//                setTextSize(
//                    TypedValue.COMPLEX_UNIT_PX,
//                    resources.getDimension(R.dimen.text_xxsmall)
//                )
            }
            MEDIUM -> {
//                setTextSize(
//                    TypedValue.COMPLEX_UNIT_PX,
//                    resources.getDimension(R.dimen.text_medium)
//                )
            }
            LARGE -> {
                when (context.getDensityDpi()) {
                    in 400..449 -> {
//                        setTextSize(
//                            TypedValue.COMPLEX_UNIT_PX,
//                            resources.getDimension(R.dimen.text_xxxlarge)
//                        )
                    }
                    in 450..500 -> {
//                        setTextSize(
//                            TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_normal)
//                        )
                    }
                    else -> {
//                        setTextSize(
//                            TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_medium)
//                        )
                    }
                }
            }
            else -> {
//                setTextSize(
//                    TypedValue.COMPLEX_UNIT_PX,
//                    resources.getDimension(R.dimen.text_medium)
//                )
            }
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

    override suspend fun getFontSize(fontSizeDAO: DSFontSizeDAO, value: String): Int {
        return super.getFontSize(fontSizeDAO, value)
    }

    override suspend fun getColorPrimary(colorDAO: DSColorDAO, value: String): String? {
        return super.getColorPrimary(colorDAO, value)
    }

    override suspend fun getNeutralColor(colorDAO: DSColorDAO, value: String): String? {
        return super.getNeutralColor(colorDAO, value)
    }
}