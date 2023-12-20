package com.kusitms.data.local

import android.util.Log

object AuthDataStore {
    private const val KEY_AUTH_TOKEN = "KEY_AUTH_TOKEN"
    private const val KEY_USER_INFO = "KEY_USER_INFO"
    private const val KEY_MEMBER_DETAIL_EXIST = "KEY_MEMBER_DETAIL_EXIST"
    private const val KEY_MEMBER_PERIOD = "KEY_MEMBER_PERIOD"


    var authToken: String
        get() = DataStoreUtils.getSyncData(KEY_AUTH_TOKEN, "")
        set(value) {
            Log.d("AuthDataStore_authToken", "Saving Auth Token: $value")
            DataStoreUtils.saveSyncStringData(KEY_AUTH_TOKEN, value)
        }

    var isExistProfile: Boolean
        get() = DataStoreUtils.getSyncData(KEY_MEMBER_DETAIL_EXIST, false)
        set(value)  {
            DataStoreUtils.saveSyncBooleanData(KEY_MEMBER_DETAIL_EXIST, value)
            Log.d("AuthDataStore_isExistProfile", "Saving ExistProfile: $value")
        }

            var period: String
            get() = DataStoreUtils.getSyncData(KEY_MEMBER_PERIOD, "")
            set(value) {
                DataStoreUtils.saveSyncStringData(KEY_MEMBER_PERIOD, value)
                Log.d("AuthDataStore_period", "Saving Period: $value")
            }
}