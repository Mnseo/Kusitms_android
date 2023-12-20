package com.kusitms.kusitms

import android.app.Application
import com.kusitms.data.local.DataStoreUtils
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class KusitmsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        DataStoreUtils.init(this)
        Timber.plant(Timber.DebugTree())
    }
}