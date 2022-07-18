package com.wallace.design_system.data.storage

import com.wallace.design_system.data.model.DesignSystemModel

interface DataStoreHelper {
    suspend fun getContent(): ArrayList<DesignSystemModel.DsToken>

    suspend fun getTokenByReference(referenceName: String) = getContent().find {
        it.name == referenceName
    }?.values

}