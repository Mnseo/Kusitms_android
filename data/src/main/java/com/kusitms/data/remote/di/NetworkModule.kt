package com.kusitms.data.remote.di


import com.kusitms.data.BuildConfig
import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.api.KusitmsTokenApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider
import javax.inject.Qualifier


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    val kusitmsServer: String = BuildConfig.KUSITMS_SERVER

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class TokenInterceptorOkHttpClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class InterceptorOkHttpClient

    @Provides
    @Singleton
    fun provideKusitmsApi(@TokenInterceptorOkHttpClient  okHttpClient: OkHttpClient): KusitmsApi {
        return Retrofit.Builder()
            .baseUrl(kusitmsServer)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KusitmsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideKusitmsTokenApi(@InterceptorOkHttpClient okHttpClient: OkHttpClient): KusitmsTokenApi {
        return Retrofit.Builder()
            .baseUrl(kusitmsServer)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KusitmsTokenApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthDataStore(): AuthDataStore {
        return AuthDataStore()
    }

    @Provides
    @Singleton
    fun provideTokenManager(
        kusitmsTokenApi: KusitmsTokenApi,
        authDataStore: AuthDataStore
    ): TokenManager {
        return TokenManager(kusitmsTokenApi, authDataStore)
    }


    @Provides
    @Singleton
    fun provideAuthTokenInterceptor(
        authDataStore: AuthDataStore,
        tokenManager: TokenManager
    ): AuthTokenInterceptor {
        return AuthTokenInterceptor(authDataStore,tokenManager)
    }



    @InterceptorOkHttpClient
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @TokenInterceptorOkHttpClient
    @Provides
    @Singleton
    fun provideTokenOkHttpClient(
        authTokenInterceptor: AuthTokenInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(authTokenInterceptor)
            .build()
    }
}