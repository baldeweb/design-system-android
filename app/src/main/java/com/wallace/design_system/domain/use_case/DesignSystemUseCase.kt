package com.wallace.design_system.domain.use_case

import com.wallace.design_system.data.model.DesignSystemModel
import retrofit2.Response

interface DesignSystemUseCase {
    suspend fun getDesignSystem(): Response<ArrayList<DesignSystemModel.DesignSystemModelItem>>
}