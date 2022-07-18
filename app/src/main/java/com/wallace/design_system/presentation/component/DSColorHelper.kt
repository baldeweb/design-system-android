package com.wallace.design_system.presentation.component

import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.DSColorDAO
import com.wallace.design_system.data.storage.DSGradientColorDAO
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_PRIMARY_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_PRIMARY_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_PRIMARY_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_PRIMARY_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_SECONDARY_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_SECONDARY_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_SECONDARY_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_SECONDARY_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_HELPER_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_HELPER_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_HELPER_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_HELPER_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_SUCCESS_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_SUCCESS_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_SUCCESS_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_SUCCESS_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_WARNING_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_WARNING_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_WARNING_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_WARNING_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_HIGHLIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_PRIMARY
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_SECONDARY
import com.wallace.design_system.data.utils.DSColorConstants.DS_HIGHLIGHT_COLOR_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_HIGHLIGHT_COLOR_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_HIGHLIGHT_COLOR_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_HIGHLIGHT_COLOR_PURE

interface DSColorHelper {

    suspend fun getGradientColor(
        gradientColorDAO: DSGradientColorDAO, value: String
    ): DesignSystemModel.DsToken? = when (value) {
        DS_GRADIENT_COLOR_PRIMARY -> gradientColorDAO.getGradientColorPrimary()
        DS_GRADIENT_COLOR_SECONDARY -> gradientColorDAO.getGradientColorPrimary()
        DS_GRADIENT_COLOR_HIGHLIGHT -> gradientColorDAO.getGradientColorPrimary()
        else -> null
    }

    suspend fun getColorPrimary(colorDAO: DSColorDAO, value: String): String? = when (value) {
        DS_BRAND_COLOR_PRIMARY_PURE -> colorDAO.getBrandColorPrimaryPure()
        DS_BRAND_COLOR_PRIMARY_LIGHT -> colorDAO.getBrandColorPrimaryLight()
        DS_BRAND_COLOR_PRIMARY_MEDIUM -> colorDAO.getBrandColorPrimaryMedium()
        DS_BRAND_COLOR_PRIMARY_DARK -> colorDAO.getBrandColorPrimaryDark()
        else -> ""
    }

    suspend fun getColorSecondary(colorDAO: DSColorDAO, value: String): String? = when (value) {
        DS_BRAND_COLOR_SECONDARY_PURE -> colorDAO.getBrandColorSecondaryPure()
        DS_BRAND_COLOR_SECONDARY_LIGHT -> colorDAO.getBrandColorSecondaryLight()
        DS_BRAND_COLOR_SECONDARY_MEDIUM -> colorDAO.getBrandColorSecondaryMedium()
        DS_BRAND_COLOR_SECONDARY_DARK -> colorDAO.getBrandColorSecondaryDark()
        else -> ""
    }

    suspend fun getHighlightColor(colorDAO: DSColorDAO, value: String): String? = when (value) {
        DS_HIGHLIGHT_COLOR_PURE -> colorDAO.getHighlightColorPure()
        DS_HIGHLIGHT_COLOR_LIGHT -> colorDAO.getHighlightColorLight()
        DS_HIGHLIGHT_COLOR_MEDIUM -> colorDAO.getHighlightColorMedium()
        DS_HIGHLIGHT_COLOR_DARK -> colorDAO.getHighlightColorDark()
        else -> ""
    }

    suspend fun getFeedbackColorSuccess(colorDAO: DSColorDAO, value: String): String? =
        when (value) {
            DS_FEEDBACK_COLOR_SUCCESS_PURE -> colorDAO.getFeedbackColorSuccessPure()
            DS_FEEDBACK_COLOR_SUCCESS_LIGHT -> colorDAO.getFeedbackColorSuccessLight()
            DS_FEEDBACK_COLOR_SUCCESS_MEDIUM -> colorDAO.getFeedbackColorSuccessMedium()
            DS_FEEDBACK_COLOR_SUCCESS_DARK -> colorDAO.getFeedbackColorSuccessDark()
            else -> ""
        }

    suspend fun getFeedbackColorHelper(colorDAO: DSColorDAO, value: String): String? =
        when (value) {
            DS_FEEDBACK_COLOR_HELPER_PURE -> colorDAO.getFeedbackColorSuccessPure()
            DS_FEEDBACK_COLOR_HELPER_LIGHT -> colorDAO.getFeedbackColorHelperLight()
            DS_FEEDBACK_COLOR_HELPER_MEDIUM -> colorDAO.getFeedbackColorHelperMedium()
            DS_FEEDBACK_COLOR_HELPER_DARK -> colorDAO.getFeedbackColorHelperDark()
            else -> ""
        }

    suspend fun getFeedbackColorWarning(colorDAO: DSColorDAO, value: String): String? =
        when (value) {
            DS_FEEDBACK_COLOR_WARNING_PURE -> colorDAO.getFeedbackColorWarningPure()
            DS_FEEDBACK_COLOR_WARNING_LIGHT -> colorDAO.getFeedbackColorWarningLight()
            DS_FEEDBACK_COLOR_WARNING_MEDIUM -> colorDAO.getFeedbackColorWarningMedium()
            DS_FEEDBACK_COLOR_WARNING_DARK -> colorDAO.getFeedbackColorWarningDark()
            else -> ""
        }
}