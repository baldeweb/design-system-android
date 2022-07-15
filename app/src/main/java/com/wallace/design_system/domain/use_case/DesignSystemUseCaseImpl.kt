package com.wallace.design_system.domain.use_case

import android.content.Context
import com.google.gson.Gson
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_FONT_FAMILY
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.*
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_BORDER_RADIUS
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_BORDER_WIDTH
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_COLOR
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_FONT_SIZE
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_FONT_WEIGHT
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_GRADIENT_COLOR
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_LINE_HEIGHT
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_OPACITY_LEVELS
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_SHADOW
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_SPACING
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_SPACING_INSETS
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
    val borderWidth: DSBorderWidthDAO,
    val opacityLevels: DSOpacityLevelsDAO,
    val shadowDAO: DSShadowDAO,
    val spacingDAO: DSSpacingDAO,
    val spacingInset: DSSpacingInsetDAO,
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
            fontFamilyDAO.insertData(Gson().toJson(it))
        }
    }

    override suspend fun getDesignSystemByCategory(category: String): DesignSystemModel.Data? {
        return when(category) {
            DS_FONT_FAMILY -> fontFamilyDAO.getDataConverted()
            DS_FONT_WEIGHT -> fontWeightDAO.getDataConverted()
            DS_GRADIENT_COLOR -> gradientColorDAO.getDataConverted()
            DS_COLOR -> colorDAO.getDataConverted()
            DS_FONT_SIZE -> fontSizeDAO.getDataConverted()
            DS_LINE_HEIGHT -> lineHeightDAO.getDataConverted()
            DS_BORDER_RADIUS -> borderRadiusDAO.getDataConverted()
            DS_BORDER_WIDTH -> borderWidth.getDataConverted()
            DS_OPACITY_LEVELS -> opacityLevels.getDataConverted()
            DS_SHADOW -> shadowDAO.getDataConverted()
            DS_SPACING -> spacingDAO.getDataConverted()
            DS_SPACING_INSETS -> spacingInset.getDataConverted()
            else -> null
        }
    }
}