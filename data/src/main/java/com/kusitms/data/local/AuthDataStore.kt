package com.kusitms.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.kusitms.domain.model.login.LoginMemberProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

class AuthDataStore @Inject constructor(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    companion object {
        val AUTH_TOKEN_KEY = stringPreferencesKey("auth_token")
        val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
        val IS_LOGIN = booleanPreferencesKey("is_login")
        val KEY_LOGIN_MEMBER_PROFILE = stringPreferencesKey("login_member_profile")
    }

    suspend fun saveAuthToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[AUTH_TOKEN_KEY] = token
        }
    }

    suspend fun saveLoginMemberProfile(profile: LoginMemberProfile?) {
        val json = Gson().toJson(profile)
        context.dataStore.edit { preferences ->
            preferences[KEY_LOGIN_MEMBER_PROFILE] = json
        }
    }

    val loginMemberProfile: Flow<LoginMemberProfile?> = context.dataStore.data
        .map { preferences ->
            val json = preferences[KEY_LOGIN_MEMBER_PROFILE] ?: return@map null
            return@map Gson().fromJson(json, LoginMemberProfile::class.java)
        }

    suspend fun updateLogin(isLogin: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LOGIN] =  isLogin
        }
    }

    suspend fun saveRefreshToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[REFRESH_TOKEN_KEY] = token
        }
    }

    suspend fun clearAllData() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    val authToken: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[AUTH_TOKEN_KEY]
        }

    val refreshToken: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[REFRESH_TOKEN_KEY]
        }

    val isLogin: Flow<Boolean?> = context.dataStore.data
        .map { preferences ->
            preferences[IS_LOGIN]
        }
}
