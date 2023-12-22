package com.kusitms.data.remote.di

import com.kusitms.data.LoginRepositoryImpl
import com.kusitms.data.NoticeRepositoryImpl
import com.kusitms.domain.repository.LoginRepository
import com.kusitms.domain.repository.NoticeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
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

    @Provides
    fun bindSigninRepository(signInRepositoryImpl: SignInRepositoryImpl):
            SignInRepository = signInRepositoryImpl

    @Provides
    fun bindFindPwRepository(findPwRepositoryImpl: FindPwRepositoryImpl):
            FindPwRepository = findPwRepositoryImpl
}