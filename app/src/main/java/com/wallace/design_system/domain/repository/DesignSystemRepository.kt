package com.wallace.design_system.domain.repository

import com.wallace.design_system.data.model.DesignSystemModel
import retrofit2.Response

interface DesignSystemRepository {
    suspend fun getDesignSystem(): Response<ArrayList<DesignSystemModel.Response>>
}