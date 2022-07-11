package com.wallace.design_system.presentation.watcher

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText
import com.wallace.design_system.data.utils.cleanMask
import com.wallace.design_system.data.utils.isValidCPF

class CPFWatcher (
    private val context: Context,
    private var editText: TextInputEditText,
    private val onValid: () -> Unit,
    private val onNeutral: (String) -> Unit,
    private val onInvalid: (String) -> Unit
) : TextWatcher {
    companion object {

        fun getMaskedText(text: String): String {
            var tempText = text.cleanMask()

            for (i in 1..tempText.length) {
                if (i % 3 == 0) {
                    val symbolIndex = i + tempText.split(".").size - 1
                    tempText = if (i < 9) {
                        StringBuilder(tempText).insert(symbolIndex, ".").toString()
                    } else {
                        StringBuilder(tempText).insert(symbolIndex, "-").toString()
                    }
                }
            }

            return tempText
        }
    }

    override fun afterTextChanged(text: Editable?) {
        if (editText.text.toString().cleanMask().isValidCPF()) {
            onValid.invoke()
        } else if (!editText.text.toString().cleanMask().isValidCPF() && (text?.length ?: 0) < 11) {
            onNeutral.invoke(editText.text.toString().cleanMask())
        } else {
            onInvalid.invoke("")
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
        val cpfNumber = charSequence.toString()
        val maskedText = getMaskedText(cpfNumber)

        editText.removeTextChangedListener(this)

        editText.setText(maskedText)

        val isDelete = count == 0
        try {
            editText.setSelection(getEditTextSelection(isDelete, start, maskedText))
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        editText.addTextChangedListener(this)
    }

    private fun getEditTextSelection(isDelete: Boolean, start: Int, text: String): Int {
        return if (isDelete) {
            start
        } else {
            if (start + 1 < text.length && (text[start + 1].toString() == "." || text[start + 1].toString() == "-")) {
                start + 2
            } else {
                start + 1
            }
        }
    }
}