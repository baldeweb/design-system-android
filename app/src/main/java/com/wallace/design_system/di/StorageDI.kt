package com.wallace.design_system.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStoreFile
import com.wallace.design_system.data.storage.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.reflect.KClass

class StorageDI {
    fun getModule(): Module {
        return module {
            fun providePreferencesDataStore(appContext: Application): DataStore<Preferences> {
                return PreferenceDataStoreFactory.create(
                    corruptionHandler = ReplaceFileCorruptionHandler(
                        produceNewData = { emptyPreferences() }
                    ),
                    scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
                    produceFile = { appContext.preferencesDataStoreFile("design_system_preferences_db") }
                )
            }
            single { providePreferencesDataStore(androidApplication()) }
            factory { DataStoreManager<KClass<*>>(get(), get(), get()) }
            factory { DSFontFamilyDAO(get(), get(), stringPreferencesKey("ds_font_family_preferences")) }
            factory { DSFontWeightDAO(get(),get(), stringPreferencesKey("ds_font_weight_preferences")) }
            factory { DSGradientColorDAO(get(), get(), stringPreferencesKey("ds_gradient_color_preferences")) }
            factory { DSColorDAO(get(), get(), stringPreferencesKey("ds_color_preferences")) }
            factory { DSFontSizeDAO(get(), get(), stringPreferencesKey("ds_font_size_preferences")) }
            factory { DSLineHeightDAO(get(), get(), stringPreferencesKey("ds_line_height_preferences")) }
            factory { DSBorderRadiusDAO(get(), get(), stringPreferencesKey("ds_border_radius_preferences")) }
            factory { DSBorderWidthDAO(get(), get(), stringPreferencesKey("ds_border_width_preferences")) }
            factory { DSOpacityLevelsDAO(get(), get(), stringPreferencesKey("ds_opacity_levels_preferences")) }
            factory { DSShadowDAO(get(), get(), stringPreferencesKey("ds_shadow_preferences")) }
            factory { DSSpacingDAO(get(), get(), stringPreferencesKey("ds_spacing_preferences")) }
            factory { DSSpacingInsetDAO(get(), get(), stringPreferencesKey("ds_spacing_inset_preferences")) }
        }
    }
}