package com.kusitms.data.local

object AuthDataStore {
    private const val KEY_AUTH_TOKEN = "KEY_AUTH_TOKEN"
    private const val KEY_USER_INFO = "KEY_USER_INFO"

    var authToken: String
        get() = DataStoreUtils.getSyncData(KEY_AUTH_TOKEN, "")
        set(value) = DataStoreUtils.saveSyncStringData(KEY_AUTH_TOKEN, value = value)

    var userJson: String
        get() = DataStoreUtils.getSyncData(KEY_USER_INFO, "")
        set(value) = DataStoreUtils.saveSyncStringData(KEY_USER_INFO, value = value)

}