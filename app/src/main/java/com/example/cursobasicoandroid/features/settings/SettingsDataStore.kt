package com.example.cursobasicoandroid.features.settings

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.cursobasicoandroid.features.settings.PreferencesKey.NOTIFICATIONS
import com.example.cursobasicoandroid.features.settings.PreferencesKey.SOUNDS
import com.example.cursobasicoandroid.features.settings.PreferencesKey.USERNAME
import com.example.cursobasicoandroid.features.settings.PreferencesKey.VIBRATIONS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.datastore by preferencesDataStore(name="settings")

private object PreferencesKey{
    val NOTIFICATIONS = booleanPreferencesKey("notifications")
    val SOUNDS = booleanPreferencesKey("sounds")
    val VIBRATIONS = booleanPreferencesKey("vibrations")
    val USERNAME = stringPreferencesKey("username")
}

class SettingsDataStore(private val context: Context) {

    val notificationsEnabled: Flow<Boolean> = context.datastore.data.map { preferences ->
        preferences[NOTIFICATIONS] ?: true
    }

    val soundsEnabled: Flow<Boolean> = context.datastore.data.map { preferences ->
        preferences[SOUNDS] ?: false
    }

    val vibrationsEnabled: Flow<Boolean> = context.datastore.data.map { preferences ->
        preferences[VIBRATIONS] ?: true
    }

    val username: Flow<String> = context.datastore.data.map { preferences ->
        preferences[USERNAME] ?: ""
    }

    suspend fun setNotificationsEnabled(enabled: Boolean) {
        context.datastore.edit { preferences ->
            preferences[NOTIFICATIONS] = enabled
        }
    }

    suspend fun setSoundsEnabled(enabled: Boolean) {
        context.datastore.edit { preferences ->
            preferences[SOUNDS] = enabled
        }
    }

    suspend fun setVibrationsEnabled(enabled: Boolean) {
        context.datastore.edit { preferences ->
            preferences[VIBRATIONS] = enabled
        }
    }

    suspend fun setUsername(username: String) {
        context.datastore.edit { preferences ->
            preferences[USERNAME] = username
        }
    }

    suspend fun resetSettings() {
        context.datastore.edit { preferences ->
            preferences.clear()
        }
    }
}