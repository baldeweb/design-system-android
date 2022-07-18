package com.wallace.design_system.presentation.component

import com.wallace.design_system.R
import com.wallace.design_system.data.storage.DSFontFamilyDAO
import com.wallace.design_system.data.storage.DSFontSizeDAO
import com.wallace.design_system.data.storage.DSFontWeightDAO
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_FAMILY_BASE
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_FAMILY_HIGHLIGHT
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_MULISH
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_MUSEO
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_LG
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_MD
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_SM
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XL
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XS
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XXL
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XXS
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XXXL
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XXXS
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_BLACK
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_BOLD
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_LIGHT
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_MEDIUM
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_REGULAR

interface DSFontHelper {

    suspend fun getFontFamily(fontFamilyDAO: DSFontFamilyDAO, value: String): String? =
        when (value) {
            DS_FONT_FAMILY_BASE -> fontFamilyDAO.getFontFamilyBase()?.name
            DS_FONT_FAMILY_HIGHLIGHT -> fontFamilyDAO.getFontFamilyHighlight()?.name
            else -> null
        }

    suspend fun getFontWeight(fontWeightDAO: DSFontWeightDAO, value: String): String? =
        when (value) {
            DS_FONT_WEIGHT_BLACK -> fontWeightDAO.getFontWeightBlack()?.value
            DS_FONT_WEIGHT_BOLD -> fontWeightDAO.getFontWeightBold()?.value
            DS_FONT_WEIGHT_MEDIUM -> fontWeightDAO.getFontWeightMedium()?.value
            DS_FONT_WEIGHT_REGULAR -> fontWeightDAO.getFontWeightRegular()?.value
            DS_FONT_WEIGHT_LIGHT -> fontWeightDAO.getFontWeightLight()?.value
            else -> null
        }

    suspend fun getFontSize(fontSizeDAO: DSFontSizeDAO, value: String): Int = when (value) {
        DS_FONT_SIZE_XXXS -> fontSizeDAO.getFontSizeXXXS()
        DS_FONT_SIZE_XXS -> fontSizeDAO.getFontSizeXXS()
        DS_FONT_SIZE_XS -> fontSizeDAO.getFontSizeXS()
        DS_FONT_SIZE_SM -> fontSizeDAO.getFontSizeSM()
        DS_FONT_SIZE_MD -> fontSizeDAO.getFontSizeMD()
        DS_FONT_SIZE_LG -> fontSizeDAO.getFontSizeLG()
        DS_FONT_SIZE_XL -> fontSizeDAO.getFontSizeXL()
        DS_FONT_SIZE_XXL -> fontSizeDAO.getFontSizeXXL()
        DS_FONT_SIZE_XXXL -> fontSizeDAO.getFontSizeXXXL()
        else -> 14
    }

    suspend fun getTypeFace(
        fontFamilyDAO: DSFontFamilyDAO, fontWeightDAO: DSFontWeightDAO, value: String
    ): Int {
        val fontFamilyBaseReference = getFontFamily(fontFamilyDAO, DS_FONT_FAMILY_BASE) ?: ""
        val fontFamilyHighlightReference = getFontFamily(fontFamilyDAO, DS_FONT_FAMILY_HIGHLIGHT) ?: ""
        val fontWeightBase = fontWeightDAO.getTokenByReference(fontFamilyBaseReference)?.value
        val fontWeightHighlight = fontWeightDAO.getTokenByReference(fontFamilyHighlightReference)?.value

        return when(fontFamilyBaseReference) {
            DS_FONT_MULISH -> {
                when {
                    fontWeightBase == "regular" || fontWeightHighlight == "300" -> R.font.mulish_regular
                    fontWeightBase == "light" || fontWeightHighlight == "100" -> R.font.mulish_light
                    fontWeightBase == "medium" || fontWeightHighlight == "500" -> R.font.mulish_medium
                    fontWeightBase == "bold" || fontWeightHighlight == "700" -> R.font.mulish_bold
                    fontWeightBase == "black" || fontWeightHighlight == "900" -> R.font.mulish_black
                    else -> R.font.mulish_regular
                }
            }
            DS_FONT_MUSEO -> {
                when {
                    fontWeightBase == "regular" || fontWeightHighlight == "300" -> R.font.museo_regular
                    fontWeightBase == "light" || fontWeightHighlight == "100" -> R.font.museo_light
                    fontWeightBase == "medium" || fontWeightHighlight == "500" -> R.font.museo_medium
                    fontWeightBase == "bold" || fontWeightHighlight == "700" -> R.font.museo_bold
                    fontWeightBase == "black" || fontWeightHighlight == "900" -> R.font.museo_black
                    else -> R.font.museo_regular
                }
            }
            else -> R.font.mulish_regular
        }
    }
}