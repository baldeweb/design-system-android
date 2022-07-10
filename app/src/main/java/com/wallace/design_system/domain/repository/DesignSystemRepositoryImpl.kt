package com.wallace.design_system.domain.repository

import android.content.Context
import com.wallace.design_system.data.api.DesignSystemAPI
import com.wallace.design_system.data.service.ServiceManager
import com.wallace.design_system.domain.base.BaseRepository

class DesignSystemRepositoryImpl(context: Context) :
    BaseRepository<DesignSystemAPI>(context), DesignSystemRepository {

    override suspend fun getDesignSystem() = api.create<DesignSystemAPI>().getDesignSystem()
}