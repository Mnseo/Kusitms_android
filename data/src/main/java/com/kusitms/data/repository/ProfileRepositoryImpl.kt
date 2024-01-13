package com.kusitms.data.repository

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.response.profile.toModel
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
): ProfileRepository {

    override suspend fun getProfileList(): Result<List<ProfileModel>>{
        return try {
            val response = kusitmsApi.getInfoListMember()
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.map { it.toModel() })
            } else {
                Result.failure(RuntimeException("프로필 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getProfileDetail(memberId: Int): Result<ProfileModel> {
        return try {
            val response = kusitmsApi.getProfileDetail(memberId)
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(java.lang.RuntimeException("프로필 상세 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}