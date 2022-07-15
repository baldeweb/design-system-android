package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

open class DataStoreManager<T>(
    private val context: Context,
    prefsKey: Preferences.Key<T>
) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "design_system_preferences")
    }

    private var _prefsKey: Preferences.Key<T> = prefsKey

    open suspend fun insertData(value: T) {
        context.dataStore.edit { prefs ->
            prefs[_prefsKey] = value
        }
    }

    open fun getData(): Flow<T?> {
        return context.dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            preferences[_prefsKey]
        }
    }

    open suspend fun updateData(value: T) {
        context.dataStore.edit { prefs ->
            prefs.clear()
            prefs[_prefsKey] = value
        }
    }

    open suspend fun removeData() {
        context.dataStore.edit { prefs ->
            prefs.remove(_prefsKey)
            prefs.clear()
        }
    }
}