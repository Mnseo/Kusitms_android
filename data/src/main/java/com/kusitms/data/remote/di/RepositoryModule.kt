package com.kusitms.data.remote.di

import com.kusitms.data.LoginRepositoryImpl
import com.kusitms.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl):
            LoginRepository = loginRepositoryImpl
}