package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_GIANT
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_HUGE
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_LG
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_MD
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_NANO
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_QUARCK
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_SM
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XL
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XS
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XXL
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XXS
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XXXL
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XXXS
import com.wallace.design_system.data.utils.convertToObject

class DSSpacingDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): DesignSystemModel.Value? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getSpacingQuarck() = getContent().find {
        it.name == DS_SPACING_QUARCK
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingNano() = getContent().find {
        it.name == DS_SPACING_NANO
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingXxxs() = getContent().find {
        it.name == DS_SPACING_XXXS
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingXxs() = getContent().find {
        it.name == DS_SPACING_XXS
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingXs() = getContent().find {
        it.name == DS_SPACING_XS
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingSm() = getContent().find {
        it.name == DS_SPACING_SM
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingMd() = getContent().find {
        it.name == DS_SPACING_MD
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingLg() = getContent().find {
        it.name == DS_SPACING_LG
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingXl() = getContent().find {
        it.name == DS_SPACING_XL
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingXxl() = getContent().find {
        it.name == DS_SPACING_XXL
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingXxxl() = getContent().find {
        it.name == DS_SPACING_XXXL
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingHuge() = getContent().find {
        it.name == DS_SPACING_HUGE
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingGiant() = getContent().find {
        it.name == DS_SPACING_GIANT
    }?.values?.first()?.value?.toInt() ?: 10
}