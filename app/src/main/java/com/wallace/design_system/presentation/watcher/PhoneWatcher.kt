package com.wallace.design_system.presentation.watcher

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText
import com.wallace.design_system.data.utils.cleanFormatting
import com.wallace.design_system.data.utils.isValidPhoneNumber
import com.wallace.design_system.data.utils.toPhoneMask

class PhoneWatcher(
    private val context: Context,
    private val edt: TextInputEditText,
    private val onValid: () -> Unit,
    private val onNeutral: (String) -> Unit,
    private val onInvalid: (String) -> Unit
) : TextWatcher {
    private var cleanText = ""
    private var textMasked = ""

    override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(text: Editable?) {
        edt.removeTextChangedListener(this)
        text?.replace(0, text.length, textMasked)
        edt.setSelection(text?.length ?: 0)
        edt.addTextChangedListener(this)
    }

    override fun onTextChanged(cs: CharSequence?, start: Int, before: Int, count: Int) {
        val text = cs.toString()
        cleanText = text.cleanFormatting()

        when {
            cleanText.length == 11 -> {
                when {
                    cleanText.isValidPhoneNumber() -> phoneValidation()
                    else -> invalidValidation()
                }
            }
            cleanText.length < 11 -> neutralValidation()
            else -> invalidValidation()
        }
    }

    private fun phoneValidation() {
        setMask(cleanText.toPhoneMask())
        onValid.invoke()
    }

    private fun invalidValidation() {
        cleanText = cleanText.cleanFormatting()
        textMasked = cleanText
        onInvalid.invoke("")
    }

    private fun neutralValidation() {
        cleanText = cleanText.cleanFormatting()
        textMasked = cleanText
        onNeutral.invoke(cleanText)
    }

    private fun setMask(text: String) {
        textMasked = text
    }
}