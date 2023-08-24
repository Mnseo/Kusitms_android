package com.kusitms.data.repository

interface LoginRepository {
    //회원으로 로그인하기
    suspend fun signInMember()

    //관리자로 로그인하기
    suspend fun signInManager()
}