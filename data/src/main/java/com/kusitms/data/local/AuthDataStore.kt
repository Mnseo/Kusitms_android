package com.kusitms.data.local

import android.util.Log
import com.google.gson.Gson
import com.kusitms.domain.model.login.LoginMemberProfile

object AuthDataStore {
    private const val KEY_AUTH_TOKEN = "KEY_AUTH_TOKEN"
    private const val KEY_REFRESH_TOKEN = "KEY_REFRESH_TOKEN"
    private const val KEY_USER_INFO = "KEY_USER_INFO"
    private const val KEY_LOGIN_MEMBER_PROFILE = "KEY_LOGIN_MEMBER_PROFILE"


    var authToken: String
        get() = DataStoreUtils.getSyncData(KEY_AUTH_TOKEN, "")
        set(value) {
            DataStoreUtils.saveSyncStringData(KEY_AUTH_TOKEN, value)
        }

    var refreshToken: String
        get() = DataStoreUtils.getSyncData(KEY_REFRESH_TOKEN, "")
        set(value) {
            DataStoreUtils.saveSyncStringData(KEY_REFRESH_TOKEN, value)
        }

    var loginMemberProfile: LoginMemberProfile?
        get() {
            val json = DataStoreUtils.getSyncData(KEY_LOGIN_MEMBER_PROFILE, "")
            return if (json.isNotEmpty()) {
                Gson().fromJson(json, LoginMemberProfile::class.java)
            } else {
                null
            }
        }
        set(value) {
            val json = Gson().toJson(value)
            DataStoreUtils.saveSyncStringData(KEY_LOGIN_MEMBER_PROFILE, json)
            Log.d("AuthDataStore_loginMemberProfile", "Saving LoginMemberProfile: $json")
        }
}