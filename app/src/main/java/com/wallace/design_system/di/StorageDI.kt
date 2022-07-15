package com.wallace.design_system.di

import androidx.datastore.preferences.core.stringPreferencesKey
import com.wallace.design_system.data.storage.*
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.reflect.KClass

class StorageDI {
    fun getModule(): Module {
        return module {
            single { DataStoreManager<KClass<*>>(get(), get()) }
            single { DSFontFamilyDAO(get(), stringPreferencesKey("ds_font_family_preferences")) }
            single { DSFontWeightDAO(get(), stringPreferencesKey("ds_font_weight_preferences")) }
            single { DSGradientColorDAO(get(), stringPreferencesKey("ds_gradient_color_preferences")) }
            single { DSColorDAO(get(), stringPreferencesKey("ds_color_preferences")) }
            single { DSFontSizeDAO(get(), stringPreferencesKey("ds_font_size_preferences")) }
            single { DSLineHeightDAO(get(), stringPreferencesKey("ds_line_height_preferences")) }
            single { DSBorderRadiusDAO(get(), stringPreferencesKey("ds_border_radius_preferences")) }
            single { DSBorderWidthDAO(get(), stringPreferencesKey("ds_border_width_preferences")) }
            single { DSOpacityLevelsDAO(get(), stringPreferencesKey("ds_opacity_levels_preferences")) }
            single { DSShadowDAO(get(), stringPreferencesKey("ds_shadow_preferences")) }
            single { DSSpacingDAO(get(), stringPreferencesKey("ds_spacing_preferences")) }
            single { DSSpacingInsetDAO(get(), stringPreferencesKey("ds_spacing_inset_preferences")) }
        }
    }
}