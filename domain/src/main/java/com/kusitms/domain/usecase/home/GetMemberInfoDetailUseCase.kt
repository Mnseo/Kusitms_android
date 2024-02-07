package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.repository.HomeRepository
import javax.inject.Inject

class GetMemberInfoDetailUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
) {
    suspend fun fetchLoginMemberProfile(): Result<MemberInfoDetailModel> {
        return homeRepository.getMemberInfoDetail()
    }
}