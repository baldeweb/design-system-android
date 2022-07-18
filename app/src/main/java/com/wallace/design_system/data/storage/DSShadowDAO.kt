package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.google.gson.Gson
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSShadowConstants.DS_SHADOW_LEVEL_1
import com.wallace.design_system.data.utils.DSShadowConstants.DS_SHADOW_LEVEL_2
import com.wallace.design_system.data.utils.DSShadowConstants.DS_SHADOW_LEVEL_3
import com.wallace.design_system.data.utils.DSShadowConstants.DS_SHADOW_LEVEL_4
import com.wallace.design_system.data.utils.convertToObject

class DSShadowDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): DesignSystemModel.Value? {
        return super.getTokenByReference(referenceName)
    }

    private suspend fun getShadowLevel(shadowName: String): DesignSystemModel.DSShadow {
        val shadow = getContent().find { it.name == shadowName }
        val shadowValue = shadow?.values?.firstOrNull()
        val shadowValueString = shadow?.values?.firstOrNull()?.value ?: ""
        val shadowValueObject = Gson().fromJson(shadowValueString, DesignSystemModel.DSShadowValue::class.java)
        return DesignSystemModel.DSShadow().apply {
            alpha = shadowValue?.alpha ?: 0.0
            reference = shadowValue?.reference ?: ""
            value = shadowValueObject
        }
    }

    internal suspend fun getShadowLevel1() = getShadowLevel(DS_SHADOW_LEVEL_1)
    internal suspend fun getShadowLevel2() = getShadowLevel(DS_SHADOW_LEVEL_2)
    internal suspend fun getShadowLevel3() = getShadowLevel(DS_SHADOW_LEVEL_3)
    internal suspend fun getShadowLevel4() = getShadowLevel(DS_SHADOW_LEVEL_4)
}