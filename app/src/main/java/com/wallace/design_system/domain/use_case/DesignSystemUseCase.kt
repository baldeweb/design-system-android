package com.wallace.design_system.domain.use_case

import com.wallace.design_system.data.model.DesignSystemModel
import retrofit2.Response

interface DesignSystemUseCase {
    suspend fun saveDesignSystemData(model: DesignSystemModel.Response)
//    suspend fun getDesignSystemData(category: DesignSystemEnum): DesignSystemModel.Data
//    suspend fun saveFontFamily(model: DesignSystemModel.Data)
//    suspend fun getFontFamily(): DesignSystemModel.Data
//    suspend fun saveFontWeight(model: DesignSystemModel.Data)
//    suspend fun getFontWeight(): DesignSystemModel.Data
//    suspend fun saveGradientColor(model: DesignSystemModel.Data)
//    suspend fun getGradientColor(): DesignSystemModel.Data
    suspend fun getDesignSystem(): Response<DesignSystemModel.Response>
    suspend fun getDesignSystemTokens(category: String): List<DesignSystemModel.DsToken>
}