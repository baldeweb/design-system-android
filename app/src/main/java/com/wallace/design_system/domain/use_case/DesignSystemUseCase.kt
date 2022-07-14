package com.wallace.design_system.domain.use_case

import androidx.lifecycle.LiveData
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.entities.DesignSystemEntity
import retrofit2.Response

interface DesignSystemUseCase {
    suspend fun saveDesignSystem(model: DesignSystemModel.Response)
    suspend fun getDesignSystemStorage(): DesignSystemModel.Response
    suspend fun getDesignSystem(): Response<DesignSystemModel.Response>
    suspend fun parseDesignSystemToEntity(model: DesignSystemModel.Response): DesignSystemEntity
    suspend fun parseDesignSystemToModel(entity: DesignSystemEntity): DesignSystemModel.Response
}