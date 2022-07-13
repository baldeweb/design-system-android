package com.wallace.design_system.domain.use_case

import androidx.lifecycle.LiveData
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.entities.DesignSystemEntity
import retrofit2.Response

interface DesignSystemUseCase {
    fun saveDesignSystem(model: DesignSystemModel.Response)
    fun getDesignSystemStorage(): DesignSystemModel.Response
    suspend fun getDesignSystem(): Response<DesignSystemModel.Response>
    fun parseDesignSystemToEntity(model: DesignSystemModel.Response): DesignSystemEntity
    fun parseDesignSystemToModel(entity: DesignSystemEntity): DesignSystemModel.Response
}