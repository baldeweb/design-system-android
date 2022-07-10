package com.wallace.design_system.domain.repository

import com.wallace.design_system.data.api.DesignSystemAPI

class DesignSystemRepositoryImpl(private val api: DesignSystemAPI): DesignSystemRepository {
    override suspend fun getDesignSystem() = api.getDesignSystem()
}