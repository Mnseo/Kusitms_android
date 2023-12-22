package com.kusitms.data.remote.di

import com.kusitms.data.repository.FindPwRepositoryImpl
import com.kusitms.data.repository.LoginRepositoryImpl
import com.kusitms.data.repository.SignInRepositoryImpl
import com.kusitms.domain.repository.FindPwRepository
import com.kusitms.domain.repository.LoginRepository
import com.kusitms.domain.repository.SignInRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Provides
    fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl):
            LoginRepository = loginRepositoryImpl

    @Provides
    fun bindSigninRepository(signInRepositoryImpl: SignInRepositoryImpl):
            SignInRepository = signInRepositoryImpl

    @Provides
    fun bindFindPwRepository(findPwRepositoryImpl: FindPwRepositoryImpl):
            FindPwRepository = findPwRepositoryImpl
}