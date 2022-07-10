package com.wallace.design_system.domain.use_case

import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.DesignSystemDAO
import com.wallace.design_system.domain.repository.DesignSystemRepository
import retrofit2.Response

class DesignSystemUseCaseImpl(
    val dao: DesignSystemDAO,
    val repository: DesignSystemRepository
): DesignSystemUseCase {
    override suspend fun getDesignSystem() = repository.getDesignSystem()
}