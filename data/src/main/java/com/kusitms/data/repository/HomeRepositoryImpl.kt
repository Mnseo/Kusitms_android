package com.kusitms.data.repository

import android.os.Build.VERSION_CODES.P
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.response.home.toModel
import com.kusitms.domain.model.home.*
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi,
) : HomeRepository {
    override suspend fun getMemberInfoHome(): Result<HomeProfileModel> {
        return try {
            val response = kusitmsApi.getMemberInfoHome()

            if (response.result.code == 200) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("홈 프로필 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getNoticeRecent(): Result<List<NoticeRecentModel>> {
        return try {
            val response = kusitmsApi.getNoticeRecent()

            if (response.result.code == 200) {
                Result.success(response.payload.map { it.toModel() })
            } else {
                Result.failure(RuntimeException("최근 공지 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCurriculumRecent(): Result<CurriculumRecentModel> {
        return try {
            val response = kusitmsApi.getCurriculumRecent()

            if (response.result.code == 200) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("최근 커리큘럼 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTeamMatch(): Result<List<TeamMatchingModel>> {
        return try {
            val response = kusitmsApi.getTeamMatch()

            if (response.result.code == 200) {
                Result.success(response.payload.map { it.toModel() })
            } else {
                Result.failure(RuntimeException("팀 매칭 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

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

    override suspend fun getMemberInfoList(teamId: Int): Result<List<ProfileModel>> {
        return try {
            val response = kusitmsApi.getMemberInfoList(teamId)

            if (response.result.code == 200) {
                Result.success(response.payload.map { it.toModel() })
            } else {
                Result.failure(RuntimeException("팀 매칭 프로필 리스트 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAttendCurrentList(): Result<List<AttendCurrentModel>> {
        return try {
            val response = kusitmsApi.getAttendCurrentList()

            if(response.result.code == 200) {
                Result.success(response.payload.map {it.toModel()})
            } else {
                Result.failure(RuntimeException("출석 리스트 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAttendInfo(): Result<AttendInfoModel> {
        return try {
            val response = kusitmsApi.getAttendInfo()
            if(response.result.code == 200) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("출석 리스트 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}