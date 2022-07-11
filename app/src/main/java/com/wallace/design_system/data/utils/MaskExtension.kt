package com.wallace.design_system.data.utils

fun String.toCPFMask(): String {
    val cpf: String = this
    val builder = StringBuilder()
    return try {
        builder.append(this.substring(0, 3))
        builder.append(".")
        builder.append(this.substring(3, 6))
        builder.append(".")
        builder.append(this.substring(6, 9))
        builder.append("-")
        builder.append(this.substring(9, 11))
        builder.toString()
    } catch (e: Exception) {
        cpf
    }
}

fun String.toPhoneMask(): String {
    val phone = this
    return try {
        val builder = StringBuilder()
        builder.append("(")
        builder.append(phone.substring(0, 2))
        builder.append(")")
        builder.append(phone.substring(2, 7))
        builder.append("-")
        builder.append(phone.substring(7, 11))
        builder.toString()
    } catch (e: Exception) {
        phone
    }
}