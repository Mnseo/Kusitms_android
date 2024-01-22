package com.kusitms.data.repository

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.response.home.toModel
import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi,
): HomeRepository {
    override suspend fun getMemberInfoDetail(): Result<MemberInfoDetailModel> {
        return try {
            val response = kusitmsApi.getMemberInfoDetail()

            if (response.result.code == 200) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("홈 프로필 정보 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}