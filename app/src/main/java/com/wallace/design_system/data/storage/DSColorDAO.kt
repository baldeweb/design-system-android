package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_PRIMARY_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_PRIMARY_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_PRIMARY_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_PRIMARY_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_SECONDARY_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_SECONDARY_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_SECONDARY_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_BRAND_COLOR_SECONDARY_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_HELPER_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_HELPER_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_HELPER_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_HELPER_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_SUCCESS_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_SUCCESS_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_SUCCESS_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_SUCCESS_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_WARNING_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_WARNING_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_WARNING_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_FEEDBACK_COLOR_WARNING_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_HIGHLIGHT_COLOR_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_HIGHLIGHT_COLOR_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_HIGHLIGHT_COLOR_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_HIGHLIGHT_COLOR_PURE
import com.wallace.design_system.data.utils.DSColorConstants.DS_NEUTRAL_COLOR_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_NEUTRAL_COLOR_LIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_NEUTRAL_COLOR_MEDIUM
import com.wallace.design_system.data.utils.DSColorConstants.DS_NEUTRAL_COLOR_MEDIUM_DARK
import com.wallace.design_system.data.utils.DSColorConstants.DS_NEUTRAL_COLOR_MEDIUM_LIGHT
import com.wallace.design_system.data.utils.convertToObject

class DSColorDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): List<DesignSystemModel.Value>? {
        return super.getTokenByReference(referenceName)
    }

    //  Primary Color
    internal suspend fun getBrandColorPrimaryPure() = getContent().find {
        it.name == DS_BRAND_COLOR_PRIMARY_PURE
    }?.values?.first()?.value

    internal suspend fun getBrandColorPrimaryLight() = getContent().find {
        it.name == DS_BRAND_COLOR_PRIMARY_LIGHT
    }?.values?.first()?.value

    internal suspend fun getBrandColorPrimaryMedium() = getContent().find {
        it.name == DS_BRAND_COLOR_PRIMARY_MEDIUM
    }?.values?.first()?.value

    internal suspend fun getBrandColorPrimaryDark() = getContent().find {
        it.name == DS_BRAND_COLOR_PRIMARY_DARK
    }?.values?.first()?.value

    //  Secondary Color
    internal suspend fun getBrandColorSecondaryPure() = getContent().find {
        it.name == DS_BRAND_COLOR_SECONDARY_PURE
    }?.values?.first()?.value

    internal suspend fun getBrandColorSecondaryLight() = getContent().find {
        it.name == DS_BRAND_COLOR_SECONDARY_LIGHT
    }?.values?.first()?.value

    internal suspend fun getBrandColorSecondaryMedium() = getContent().find {
        it.name == DS_BRAND_COLOR_SECONDARY_MEDIUM
    }?.values?.first()?.value

    internal suspend fun getBrandColorSecondaryDark() = getContent().find {
        it.name == DS_BRAND_COLOR_SECONDARY_DARK
    }?.values?.first()?.value

    //  Highlight Color
    internal suspend fun getHighlightColorPure() = getContent().find {
        it.name == DS_HIGHLIGHT_COLOR_PURE
    }?.values?.first()?.value

    internal suspend fun getHighlightColorLight() = getContent().find {
        it.name == DS_HIGHLIGHT_COLOR_LIGHT
    }?.values?.first()?.value

    internal suspend fun getHighlightColorMedium() = getContent().find {
        it.name == DS_HIGHLIGHT_COLOR_MEDIUM
    }?.values?.first()?.value

    internal suspend fun getHighlightColorDark() = getContent().find {
        it.name == DS_HIGHLIGHT_COLOR_DARK
    }?.values?.first()?.value

    //  Neutral Color
    internal suspend fun getNeutralColorLight() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_LIGHT
    }?.values?.first()?.value

    internal suspend fun getNeutralColorDark() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_DARK
    }?.values?.first()?.value

    internal suspend fun getNeutralColorMediumLight() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_MEDIUM_LIGHT
    }?.values?.first()?.value

    internal suspend fun getNeutralColorMedium() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_MEDIUM
    }?.values?.first()?.value

    internal suspend fun getNeutralColorMediumDark() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_MEDIUM_DARK
    }?.values?.first()?.value

    //  Feedback Color Success
    internal suspend fun getFeedbackColorSuccessPure() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_SUCCESS_PURE
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorSuccessLight() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_SUCCESS_LIGHT
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorSuccessMedium() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_SUCCESS_MEDIUM
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorSuccessDark() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_SUCCESS_DARK
    }?.values?.first()?.value

    //  Feedback Color Helper
    internal suspend fun getFeedbackColorHelperPure() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_HELPER_PURE
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorHelperLight() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_HELPER_LIGHT
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorHelperMedium() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_HELPER_MEDIUM
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorHelperDark() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_HELPER_DARK
    }?.values?.first()?.value

    //  Feedback Color Warning
    internal suspend fun getFeedbackColorWarningPure() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_WARNING_PURE
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorWarningLight() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_WARNING_LIGHT
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorWarningMedium() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_WARNING_MEDIUM
    }?.values?.first()?.value

    internal suspend fun getFeedbackColorWarningDark() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_WARNING_DARK
    }?.values?.first()?.value
}