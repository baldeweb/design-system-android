package com.wallace.design_system.data.utils

import com.google.gson.Gson
import com.wallace.design_system.data.model.DesignSystemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.util.regex.Pattern

suspend inline fun<reified T> Flow<String?>.convertToObject(): T {
    return Gson().fromJson(this.first(), T::class.java)
}

fun String.cleanMask() = this.filter { it.isDigit() }

fun String?.cleanFormatting(): String {
    var textUnmasked = this ?: ""
    textUnmasked = textUnmasked.replace(".", "")
    textUnmasked = textUnmasked.replace(",", "")
    textUnmasked = textUnmasked.replace("-", "")
    textUnmasked = textUnmasked.replace("/", "")
    textUnmasked = textUnmasked.replace("(", "")
    textUnmasked = textUnmasked.replace(" ", "")
    textUnmasked = textUnmasked.replace("+", "")
    textUnmasked = textUnmasked.replace(")", "")
    return textUnmasked
}

fun String.hasOnlyNumbers(): Boolean {
    val text = this.cleanFormatting()
    val hasNumber = Pattern.matches("\\d+", text)
    val hasLetter = Pattern.matches("[a-zA-Z]+", text)
    return hasNumber && !hasLetter
}

fun String.isSequentialNumbers(): Boolean {
    return this == "000000" ||
            this == "111111" ||
            this == "222222" ||
            this == "333333" ||
            this == "444444" ||
            this == "555555" ||
            this == "666666" ||
            this == "777777" ||
            this == "888888" ||
            this == "999999" ||
            this == "123456" ||
            this == "159357"
}

fun String.isValidCPF(): Boolean {
    if (this.isEmpty()) return false
    val numbers = this.filter { it.isDigit() }.map {
        it.toString().toInt()
    }
    if (numbers.size != 11) return false
    if (numbers.all { it == numbers[0] }) return false
    val dv1 = ((0..8).sumOf { (it + 1) * numbers[it] }).rem(11).let {
        if (it >= 10) 0 else it
    }
    val dv2 = ((0..8).sumOf { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
        if (it >= 10) 0 else it
    }
    return numbers[9] == dv1 && numbers[10] == dv2
}

fun String.isValidPhoneNumber(): Boolean {
    val validDDD =
        "11|12|13|14|15|16|17|18|19|" +
                "21|22|24|27|28|" +
                "31|32|33|34|35|37|38|" +
                "41|42|43|44|45|46|47|48|49|" +
                "51|53|54|55|" +
                "61|62|63|64|65|66|67|68|69|" +
                "71|73|74|75|77|79|" +
                "81|82|83|84|85|86|87|88|89|" +
                "91|92|93|94|95|96|97|98|99"
    val phoneRegex = "(($validDDD)(9[0-9]\\d{3})-?(\\d{4}))\$"
    val isSequential = this.isSequentialPhoneNumber()
    return Pattern.matches(phoneRegex, this) && !isSequential
}

fun String.isSequentialPhoneNumber(): Boolean {
    val phoneNumber = this.removeRange(0, 2)
    return phoneNumber == "111111111" ||
            phoneNumber == "222222222" ||
            phoneNumber == "333333333" ||
            phoneNumber == "444444444" ||
            phoneNumber == "555555555" ||
            phoneNumber == "666666666" ||
            phoneNumber == "777777777" ||
            phoneNumber == "888888888" ||
            phoneNumber == "999999999"
}

fun String.isSMSCodeValid(): Boolean {
    return this.hasOnlyNumbers() && !this.isSequentialNumbers() && this.length == 6
}