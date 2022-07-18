package com.wallace.design_system.presentation.component

import com.wallace.design_system.data.storage.DSFontFamilyDAO
import com.wallace.design_system.data.storage.DSFontSizeDAO
import com.wallace.design_system.data.storage.DSFontWeightDAO
import com.wallace.design_system.data.utils.DSFontConstants
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_FAMILY_BASE
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_FAMILY_HIGHLIGHT
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
            DS_FONT_FAMILY_BASE -> fontFamilyDAO.getFontFamilyBase()
            DS_FONT_FAMILY_HIGHLIGHT -> fontFamilyDAO.getFontFamilyHighlight()
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
}