package com.kusitms.domain.repository

import com.kusitms.domain.model.home.MemberInfoDetailModel

interface HomeRepository {
    suspend fun getMemberInfoDetail(): Result<MemberInfoDetailModel>
}