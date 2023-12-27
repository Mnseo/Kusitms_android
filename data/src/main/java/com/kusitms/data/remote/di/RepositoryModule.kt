package com.kusitms.data.remote.di

import com.kusitms.data.NoticeRepositoryImpl
import com.kusitms.data.repository.*
import com.kusitms.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindLoginRepository(
        loginRepository: LoginRepositoryImpl
    ): LoginRepository


    @Binds
    abstract fun bindNoticeRepository(
        noticeRepository: NoticeRepositoryImpl
    ): NoticeRepository

    @Binds
    abstract fun bindSigninRepository(
        signInRepositoryImpl: SignInRepositoryImpl
    ): SignInRepository


    @Binds
    abstract fun bindFindPwRepository(
        findPwRepositoryImpl: FindPwRepositoryImpl
    ): FindPwRepository

    @Binds
    abstract fun bindChangePwRepository(
        changePwRepository: ChangePwRepositoryImpl
    ): ChangePwRepository

    @Binds
    abstract fun bindAuthRepository(
        authRepository: AuthRepositoryImpl
    ): AuthRepository
}