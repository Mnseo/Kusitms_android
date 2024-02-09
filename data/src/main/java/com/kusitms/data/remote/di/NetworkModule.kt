package com.kusitms.data.remote.di


import android.content.Context
import com.kusitms.data.BuildConfig
import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.api.KusitmsTokenApi
import com.kusitms.data.remote.util.NullOnEmptyConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


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
            .addConverterFactory(NullOnEmptyConverterFactory())
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
    fun provideAuthDataStore(@ApplicationContext context: Context): AuthDataStore {
        return AuthDataStore(context)
    }


    @Provides
    @Singleton
    fun provideAuthTokenInterceptor(
        authDataStore: AuthDataStore,
    ): AuthTokenInterceptor {
        return AuthTokenInterceptor(authDataStore)
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