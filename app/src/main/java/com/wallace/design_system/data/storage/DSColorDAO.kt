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
) : DataStoreManager<String>(context, dataStore, prefsKey) {
    suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    suspend fun getTokenByReference(referenceName: String) = getContent().find {
        it.name == referenceName
    }?.values

    //  Primary Color
    internal suspend fun getBrandColorPrimaryPure() = getContent().find {
        it.name == DS_BRAND_COLOR_PRIMARY_PURE
    }
    internal suspend fun getBrandColorPrimaryLight() = getContent().find {
        it.name == DS_BRAND_COLOR_PRIMARY_LIGHT
    }
    internal suspend fun getBrandColorPrimaryMedium() = getContent().find {
        it.name == DS_BRAND_COLOR_PRIMARY_MEDIUM
    }
    internal suspend fun getBrandColorPrimaryDark() = getContent().find {
        it.name == DS_BRAND_COLOR_PRIMARY_DARK
    }

    //  Secondary Color
    internal suspend fun getBrandColorSecondaryPure() = getContent().find {
        it.name == DS_BRAND_COLOR_SECONDARY_PURE
    }
    internal suspend fun getBrandColorSecondaryLight() = getContent().find {
        it.name == DS_BRAND_COLOR_SECONDARY_LIGHT
    }
    internal suspend fun getBrandColorSecondaryMedium() = getContent().find {
        it.name == DS_BRAND_COLOR_SECONDARY_MEDIUM
    }
    internal suspend fun getBrandColorSecondaryDark() = getContent().find {
        it.name == DS_BRAND_COLOR_SECONDARY_DARK
    }

    //  Highlight Color
    internal suspend fun getHighlightColorPure() = getContent().find {
        it.name == DS_HIGHLIGHT_COLOR_PURE
    }
    internal suspend fun getHighlightColorLight() = getContent().find {
        it.name == DS_HIGHLIGHT_COLOR_LIGHT
    }
    internal suspend fun getHighlightColorMedium() = getContent().find {
        it.name == DS_HIGHLIGHT_COLOR_MEDIUM
    }
    internal suspend fun getHighlightColorDark() = getContent().find {
        it.name == DS_HIGHLIGHT_COLOR_DARK
    }

    //  Neutral Color
    internal suspend fun getNeutralColorLight() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_LIGHT
    }
    internal suspend fun getNeutralColorDark() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_DARK
    }
    internal suspend fun getNeutralColorMediumLight() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_MEDIUM_LIGHT
    }
    internal suspend fun getNeutralColorMedium() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_MEDIUM
    }
    internal suspend fun getNeutralColorMediumDark() = getContent().find {
        it.name == DS_NEUTRAL_COLOR_MEDIUM_DARK
    }

    //  Feedback Color Success
    internal suspend fun getFeedbackColorSuccessPure() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_SUCCESS_PURE
    }
    internal suspend fun getFeedbackColorSuccessLight() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_SUCCESS_LIGHT
    }
    internal suspend fun getFeedbackColorSuccessMedium() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_SUCCESS_MEDIUM
    }
    internal suspend fun getFeedbackColorSuccessDark() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_SUCCESS_DARK
    }

    //  Feedback Color Helper
    internal suspend fun getFeedbackColorHelperPure() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_HELPER_PURE
    }
    internal suspend fun getFeedbackColorHelperLight() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_HELPER_LIGHT
    }
    internal suspend fun getFeedbackColorHelperMedium() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_HELPER_MEDIUM
    }
    internal suspend fun getFeedbackColorHelperDark() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_HELPER_DARK
    }

    //  Feedback Color Warning
    internal suspend fun getFeedbackColorWarningPure() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_WARNING_PURE
    }
    internal suspend fun getFeedbackColorWarningLight() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_WARNING_LIGHT
    }
    internal suspend fun getFeedbackColorWarningMedium() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_WARNING_MEDIUM
    }
    internal suspend fun getFeedbackColorWarningDark() = getContent().find {
        it.name == DS_FEEDBACK_COLOR_WARNING_DARK
    }
}