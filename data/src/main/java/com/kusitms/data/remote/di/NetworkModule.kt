package com.kusitms.data.remote.di

import android.util.Log
import com.kusitms.data.BuildConfig
import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.create
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    val kusitmsServer: String = BuildConfig.KUSITMS_SERVER

    @Provides
    @Singleton
    fun provideKusitmsApi(): KusitmsApi {
        return Retrofit.Builder()
            .baseUrl(kusitmsServer)
            .client(provideOkHttpClient(AuthTokenInterceptor()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KusitmsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthTokenInterceptor(authDataStore: AuthDataStore): AuthTokenInterceptor {
        return AuthTokenInterceptor(authDataStore)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authTokenInterceptor: AuthTokenInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(authTokenInterceptor)
            .build()
    }
}