package com.kusitms.data.remote.di

import com.kusitms.data.NoticeRepositoryImpl
import com.kusitms.data.repository.FindPwRepositoryImpl
import com.kusitms.data.repository.LoginRepositoryImpl
import com.kusitms.data.repository.SignInRepositoryImpl
import com.kusitms.domain.repository.FindPwRepository
import com.kusitms.domain.repository.LoginRepository
import com.kusitms.domain.repository.NoticeRepository
import com.kusitms.domain.repository.SignInRepository
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

    @Binds
    abstract fun bindSigninRepository(
        signInRepositoryImpl: SignInRepositoryImpl
    ): SignInRepository


    @Binds
    abstract fun bindFindPwRepository(
        findPwRepositoryImpl: FindPwRepositoryImpl
    ): FindPwRepository
}