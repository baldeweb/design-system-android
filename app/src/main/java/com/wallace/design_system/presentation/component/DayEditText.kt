package com.wallace.design_system.presentation.component

import android.content.Context
import android.os.Build
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.wallace.design_system.R
import com.wallace.design_system.data.utils.DayEditTextConstants.INPUT_CPF
import com.wallace.design_system.data.utils.DayEditTextConstants.INPUT_EMAIL
import com.wallace.design_system.data.utils.DayEditTextConstants.INPUT_NUMBER
import com.wallace.design_system.data.utils.DayEditTextConstants.INPUT_PHONE
import com.wallace.design_system.data.utils.DayEditTextConstants.INPUT_SMS_CODE
import com.wallace.design_system.data.utils.DayEditTextConstants.INPUT_TEXT
import com.wallace.design_system.data.utils.DayTextViewConstants.DARK
import com.wallace.design_system.data.utils.DayTextViewConstants.LIGHT
import com.wallace.design_system.data.utils.cleanFormatting
import com.wallace.design_system.data.utils.isSMSCodeValid
import com.wallace.design_system.databinding.ComponentDayedittextBinding
import com.wallace.design_system.presentation.watcher.CPFWatcher
import com.wallace.design_system.presentation.watcher.EmailWatcher
import com.wallace.design_system.presentation.watcher.PhoneWatcher

class DayEditText(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {

    private var binding = ComponentDayedittextBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    private var _isValid: Boolean = false
    var isValid = false
        get() = _isValid
        private set

    private var _isNeutral: Boolean = false
    var isNeutral = false
        get() = _isNeutral
        private set

    private var _isInvalid: Boolean = false
    var isInvalid = false
        get() = _isInvalid
        private set

    private var _errorMessage: String = ""
    var errorMessage = ""
        get() = _errorMessage
        private set

    private var style: String = ""
    private var iconResource: Int = -1
    private var fieldType: String = ""

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.DayEditText)

//        binding.tieComponent.setTextSize(
//            TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_medium)
//        )
        binding.tieComponent.typeface = ResourcesCompat.getFont(context, R.font.mulish_bold)
        binding.tieComponent.isSingleLine = true
        binding.tieComponent.imeOptions = EditorInfo.IME_ACTION_DONE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.tieComponent.importantForAutofill = View.IMPORTANT_FOR_AUTOFILL_NO
        }

        style = attributes.getString(R.styleable.DayEditText_fieldStyle) ?: ""
        iconResource = attributes.getResourceId(R.styleable.DayEditText_fieldIcon, -1)
        setupTheme()
        fieldType = attributes.getString(R.styleable.DayEditText_fieldType) ?: INPUT_TEXT
        setupInputType(fieldType)

        binding.tilComponent.hint = attributes.getString(R.styleable.DayEditText_hint)
        binding.tilComponent.isErrorEnabled = false

        attributes.recycle()
    }

    private fun setupTheme() {
        when (style) {
            LIGHT -> setupLightTheme()
            DARK -> setupDarkTheme()
            else -> setupLightTheme()
        }
    }

    private fun setupDarkTheme() {
        binding.tilComponent.apply {
            /*setHintTextAppearance(R.style.ThemeTextInputLayout)
            defaultHintTextColor = ContextCompat.getColorStateList(context, R.color.dark_gray)
            hintTextColor = ContextCompat.getColorStateList(context, R.color.dark_gray)
            boxStrokeColor = ContextCompat.getColor(context, R.color.dark_gray)
            boxBackgroundColor = ContextCompat.getColor(context, R.color.dark_gray)
            backgroundTintList = ContextCompat.getColorStateList(context, R.color.dark_gray)
            ContextCompat.getColorStateList(context, R.color.dark_gray)?.let {
                setBoxStrokeColorStateList(it)
            }*/
            background = null
        }

        binding.tieComponent.apply {
            /*setPadding(
                resources.getDimension(R.dimen.small).toInt(),
                resources.getDimension(R.dimen.small).toInt(),
                resources.getDimension(R.dimen.small).toInt(),
                resources.getDimension(R.dimen.small).toInt()
            )
            setTextColor(ContextCompat.getColor(context, R.color.black))
            setHintTextColor(ContextCompat.getColorStateList(context, R.color.dark_gray))
            background = ContextCompat.getDrawable(context, R.drawable.bg_dayedittext_dark)
            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_normal))*/
        }

        if (iconResource != -1) {
            val iconDrawable = ContextCompat.getDrawable(context, iconResource)
//            iconDrawable?.setTintList(ContextCompat.getColorStateList(context, R.color.dark_gray))

            setupIconLeft()
        }
    }

    private fun setupLightTheme() {
        binding.tilComponent.apply {
            /*setHintTextAppearance(R.style.ThemeTextInputLayout)
            defaultHintTextColor = ContextCompat.getColorStateList(context, R.color.light_gray)
            hintTextColor = ContextCompat.getColorStateList(context, R.color.light_gray)
            boxStrokeColor = ContextCompat.getColor(context, R.color.light_gray)
            boxBackgroundColor = ContextCompat.getColor(context, R.color.light_gray)
            backgroundTintList = ContextCompat.getColorStateList(context, R.color.light_gray)
            ContextCompat.getColorStateList(context, R.color.light_gray)?.let {
                setBoxStrokeColorStateList(it)
            }*/
            background = null
        }

        binding.tieComponent.apply {
            /*setPadding(
                resources.getDimension(R.dimen.small).toInt(),
                resources.getDimension(R.dimen.small).toInt(),
                resources.getDimension(R.dimen.small).toInt(),
                resources.getDimension(R.dimen.small).toInt()
            )
            setTextColor(ContextCompat.getColor(context, R.color.light_gray))
            setHintTextColor(ContextCompat.getColorStateList(context, R.color.light_gray))
            background = ContextCompat.getDrawable(context, R.drawable.bg_dayedittext_light)
            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_normal))*/
        }

        if (iconResource != -1) {
            val iconDrawable = ContextCompat.getDrawable(context, iconResource)
//            iconDrawable?.setTintList(ContextCompat.getColorStateList(context, R.color.light_gray))

            setupIconLeft()
        }
    }

    fun setupErrorStyle(errorMsg: String?) {
        if (!errorMsg.isNullOrEmpty()) {
            binding.tvwDayedittextComponentErrorMessage.visibility = VISIBLE
            binding.tvwDayedittextComponentErrorMessage.text = errorMsg
//            binding.tieComponent.background =
//                ContextCompat.getDrawable(context, R.drawable.bg_dayedittext_error)
        } else {
            binding.tvwDayedittextComponentErrorMessage.visibility = GONE
            binding.tvwDayedittextComponentErrorMessage.text = ""
            binding.tieComponent.background = null
        }
    }

    private fun setupInputType(type: String?) {
        when (type) {
            INPUT_TEXT -> {
                binding.tieComponent.inputType = InputType.TYPE_CLASS_TEXT
            }
            INPUT_NUMBER -> {
                binding.tieComponent.inputType = InputType.TYPE_CLASS_NUMBER
            }
            INPUT_PHONE -> {
                binding.tieComponent.filters = arrayOf<InputFilter>(LengthFilter(14))
                binding.tieComponent.inputType = InputType.TYPE_CLASS_PHONE
                binding.tieComponent.addTextChangedListener(
                    PhoneWatcher(context, binding.tieComponent, {
                        setupStyleForValidField()
                    }, {
                        setupStyleForNeutralField()
                    }, {
                        setupStyleForInvalidField(it)
                    })
                )
            }
            INPUT_EMAIL -> {
                binding.tieComponent.filters = arrayOf<InputFilter>(LengthFilter(60))
                binding.tieComponent.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                binding.tieComponent.addTextChangedListener(
                    EmailWatcher(context, binding.tieComponent, {
                        setupStyleForValidField()
                    }, {
                        setupStyleForInvalidField(it)
                    })
                )
            }
            INPUT_CPF -> {
                binding.tieComponent.filters = arrayOf<InputFilter>(LengthFilter(14))
                binding.tieComponent.keyListener = DigitsKeyListener.getInstance("0123456789.-")
                binding.tieComponent.inputType =
                    InputType.TYPE_NUMBER_FLAG_SIGNED or InputType.TYPE_CLASS_NUMBER
                binding.tieComponent.addTextChangedListener(
                    CPFWatcher(context, binding.tieComponent, {
                        setupStyleForValidField()
                    }, {
                        setupStyleForNeutralField()
                    }, {
                        setupStyleForInvalidField(it)
                    })
                )
            }
            INPUT_SMS_CODE -> {
                binding.tieComponent.filters = arrayOf<InputFilter>(LengthFilter(6))
                binding.tieComponent.keyListener = DigitsKeyListener.getInstance("0123456789")
                binding.tieComponent.inputType = InputType.TYPE_CLASS_NUMBER
            }
            else -> {
                binding.tieComponent.inputType = InputType.TYPE_CLASS_TEXT
            }
        }
    }

    private fun setupStyleForValidField() {
        _isValid = true
        _isNeutral = false
        _isInvalid = false
        setupErrorStyle(null)
        setupTheme()
    }

    private fun setupStyleForNeutralField() {
        _isValid = false
        _isNeutral = true
        _isInvalid = true
        setupErrorStyle(null)
        setupTheme()
    }

    private fun setupStyleForInvalidField(text: String) {
        _isValid = false
        _isNeutral = false
        _isInvalid = true
        _errorMessage = text
        setupErrorStyle(text)
    }

    private fun setupIconLeft() {
        binding.tieComponent.setCompoundDrawablesWithIntrinsicBounds(iconResource, 0, 0, 0)
//        binding.tieComponent.compoundDrawablePadding =
//            resources.getDimension(R.dimen.xxsmall).toInt()
    }

    fun getText(): String {
        return when (fieldType) {
            INPUT_CPF, INPUT_PHONE -> binding.tieComponent.text?.toString().cleanFormatting()
            else -> binding.tieComponent.text?.toString() ?: ""
        }
    }

    fun setText(text: String) {
        binding.tieComponent.setText(text)
    }

    fun setOnEditorActionListener(listener: TextView.OnEditorActionListener) {
        binding.tieComponent.setOnEditorActionListener(listener)
    }

    fun checkValidation() {
        when (fieldType) {
            INPUT_PHONE -> {
                if (getText().isEmpty() || _isInvalid) {
//                    setupStyleForInvalidField(context.getString(R.string.please_type_valid_phone))
                    return
                }
                setupStyleForValidField()
            }
            INPUT_EMAIL -> {
                if (getText().isEmpty() || _isInvalid) {
//                    setupStyleForInvalidField(context.getString(R.string.please_type_valid_email))
                    return
                }
                setupStyleForValidField()
            }
            INPUT_CPF -> {
                if (getText().isEmpty() || _isInvalid) {
//                    setupStyleForInvalidField(context.getString(R.string.please_type_valid_cpf))
                    return
                }
                setupStyleForValidField()
            }
            INPUT_SMS_CODE -> {
                if (getText().isEmpty() || !getText().isSMSCodeValid()) {
//                    setupStyleForInvalidField(context.getString(R.string.please_type_valid_code))
                    return
                }
                setupStyleForValidField()
            }
            else -> {
                if (getText().isEmpty() || _isInvalid) {
//                    setupStyleForInvalidField(context.getString(R.string.please_type_valid_any_value))
                    return
                }
                setupStyleForValidField()
            }
        }
    }
}