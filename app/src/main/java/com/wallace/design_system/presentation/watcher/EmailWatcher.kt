package com.wallace.design_system.presentation.watcher

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText

class EmailWatcher(
    private val context: Context,
    private val edt: EditText,
    private val onValid: (String) -> Unit,
    private val onInvalid: (String) -> Unit
) : TextWatcher {
    override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(text: Editable?) {
        edt.removeTextChangedListener(this)
        text?.replace(0, text.length, text.toString())
        edt.setSelection(text?.length ?: 0)
        edt.addTextChangedListener(this)
    }

    override fun onTextChanged(cs: CharSequence?, start: Int, before: Int, count: Int) {
        val text = cs.toString()

        if (Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
            emailValidation(text)
        } else {
            invalidValidation()
        }
    }

    private fun emailValidation(text: String) {
        onValid.invoke(text)
    }

    private fun invalidValidation() {
        onInvalid.invoke("")
    }

}