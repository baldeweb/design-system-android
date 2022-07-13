package com.wallace.design_system.presentation.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import com.wallace.design_system.R
import com.wallace.design_system.data.storage.room.DesignSystemDAO
import com.wallace.design_system.data.utils.DayButtonConstants.GHOST_BUTTON
import com.wallace.design_system.data.utils.DayButtonConstants.PRIMARY_BUTTON
import com.wallace.design_system.data.utils.DayButtonConstants.SECONDARY_BUTTON
import com.wallace.design_system.data.utils.DayButtonConstants.TERTIARY_BUTTON

@SuppressLint("ViewConstructor")
open class DayButton(
    dao: DesignSystemDAO,
    context: Context,
    attrs: AttributeSet?
) : AppCompatButton(context, attrs) {

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.DayButton)

        setStyle(
            attributes.getString(R.styleable.DayButton_type),
            attributes.getResourceId(R.styleable.DayButton_icon, 0)
        )
        attributes.recycle()
    }

    private fun setStyle(type: String?, iconResource: Int? = null) {
        when (type) {
            PRIMARY_BUTTON -> setPrimaryButton()
            SECONDARY_BUTTON -> setSecondaryButton()
            TERTIARY_BUTTON -> setTertiaryButton()
            GHOST_BUTTON -> setGhostButton()
            else -> setPrimaryButton()
        }
    }

    private fun setTextButton() {
        if (text.isNullOrEmpty()) {
            text = context.getString(R.string.to_continue)
        }
    }

    fun setPrimaryButton() {
        setTextButton()
//        elevation = resources.getDimension(R.dimen.xxsmall)
//        setTextSize(TypedValue.COMPLEX_UNIT_PX,context.resources.getDimension(R.dimen.text_medium))
        typeface = ResourcesCompat.getFont(context, R.font.mulish_black)
//        setTextColor(ContextCompat.getColor(context, R.color.light_gray))
//        background = AppCompatResources.getDrawable(context, R.drawable.bg_gradient_blue_green)
//        setPadding(
//            context.resources.getDimension(R.dimen.small).toInt(),
//            context.resources.getDimension(R.dimen.normal).toInt(),
//            context.resources.getDimension(R.dimen.small).toInt(),
//            context.resources.getDimension(R.dimen.normal).toInt()
//        )
    }

    fun setSecondaryButton() {
        setTextButton()
//        elevation = resources.getDimension(R.dimen.xxsmall)
//        setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.text_medium))
//        typeface = ResourcesCompat.getFont(context, R.font.mulish_semibold)
//        setTextColor(ContextCompat.getColor(context, R.color.dark_gray))
//        background = AppCompatResources.getDrawable(context, R.drawable.bg_gray)
    }

    fun setTertiaryButton() {
        setTextButton()
//        setTextSize(TypedValue.COMPLEX_UNIT_PX,context.resources.getDimension(R.dimen.text_medium))
//        typeface = ResourcesCompat.getFont(context, R.font.mulish_bold)
//        setTextColor(ContextCompat.getColor(context, R.color.dark_gray))
//        background = AppCompatResources.getDrawable(context, R.drawable.bg_gray_lined)
    }

    fun setGhostButton() {
        setTextButton()
//        elevation = resources.getDimension(R.dimen.xxsmall)
//        setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.text_medium))
//        typeface = ResourcesCompat.getFont(context, R.font.mulish_black)
//        setTextColor(ContextCompat.getColor(context, R.color.light_gray))
//        background = AppCompatResources.getDrawable(context, R.drawable.bg_cyan_rounded)
    }

    fun setButtonIcon(iconResource: Int) {
        setCompoundDrawablesWithIntrinsicBounds(iconResource, 0, 0, 0);
//        compoundDrawablePadding = resources.getDimension(R.dimen.small).toInt()
    }
}