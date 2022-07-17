package com.wallace.design_system.domain.use_case

import android.content.Context
import com.google.gson.Gson
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.*
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH
import com.wallace.design_system.data.utils.DSColorConstants.DS_COLOR
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_FAMILY
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_LINE_HEIGHT
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_OPACITY_LEVELS
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_SHADOW
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSETS
import com.wallace.design_system.data.utils.convertToObject
import com.wallace.design_system.domain.repository.DesignSystemRepository
import retrofit2.Response

class DesignSystemUseCaseImpl(
    val context: Context,
    val fontFamilyDAO: DSFontFamilyDAO,
    val fontWeightDAO: DSFontWeightDAO,
    val gradientColorDAO: DSGradientColorDAO,
    val colorDAO: DSColorDAO,
    val fontSizeDAO: DSFontSizeDAO,
    val lineHeightDAO: DSLineHeightDAO,
    val borderRadiusDAO: DSBorderRadiusDAO,
    val borderWidthDAO: DSBorderWidthDAO,
    val opacityLevelsDAO: DSOpacityLevelsDAO,
    val shadowDAO: DSShadowDAO,
    val spacingDAO: DSSpacingDAO,
    val spacingInsetDAO: DSSpacingInsetDAO,
    val repository: DesignSystemRepository
) : DesignSystemUseCase {
    override suspend fun getDesignSystem(): Response<DesignSystemModel.Response> {
        val designSystemResponse = repository.getDesignSystem()
        designSystemResponse.body()?.let { response ->
            saveDesignSystemData(response)
        }
        return designSystemResponse
    }

    override suspend fun saveDesignSystemData(model: DesignSystemModel.Response) {
        model.listData?.find { it.category == DS_FONT_FAMILY }?.let {
            fontFamilyDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_FONT_WEIGHT }?.let {
            fontWeightDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_GRADIENT_COLOR }?.let {
            gradientColorDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_COLOR }?.let {
            colorDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_FONT_SIZE }?.let {
            fontSizeDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_LINE_HEIGHT }?.let {
            lineHeightDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_BORDER_RADIUS }?.let {
            borderRadiusDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_BORDER_WIDTH }?.let {
            borderWidthDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_OPACITY_LEVELS }?.let {
            opacityLevelsDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_SHADOW }?.let {
            shadowDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_SPACING }?.let {
            spacingDAO.insertData(Gson().toJson(it.dsTokens))
        }
        model.listData?.find { it.category == DS_SPACING_INSETS }?.let {
            spacingInsetDAO.insertData(Gson().toJson(it.dsTokens))
        }
    }

    override suspend fun getDesignSystemTokens(category: String): List<DesignSystemModel.DsToken> {
        return when(category) {
            DS_FONT_FAMILY -> fontFamilyDAO.getData().convertToObject()
            DS_FONT_WEIGHT -> fontWeightDAO.getData().convertToObject()
            DS_GRADIENT_COLOR -> gradientColorDAO.getData().convertToObject()
            DS_COLOR -> colorDAO.getData().convertToObject()
            DS_FONT_SIZE -> fontSizeDAO.getData().convertToObject()
            DS_LINE_HEIGHT -> lineHeightDAO.getData().convertToObject()
            DS_BORDER_RADIUS -> borderRadiusDAO.getData().convertToObject()
            DS_BORDER_WIDTH -> borderWidthDAO.getData().convertToObject()
            DS_OPACITY_LEVELS -> opacityLevelsDAO.getData().convertToObject()
            DS_SHADOW -> shadowDAO.getData().convertToObject()
            DS_SPACING -> spacingDAO.getData().convertToObject()
            DS_SPACING_INSETS -> spacingInsetDAO.getData().convertToObject()
            else -> listOf()
        }
    }
}