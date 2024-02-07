package com.kusitms.domain.repository

import com.kusitms.domain.model.home.*
import com.kusitms.domain.model.profile.ProfileModel

interface HomeRepository {
    suspend fun getMemberInfoHome(): Result<HomeProfileModel>
    suspend fun getNoticeRecent(): Result<List<NoticeRecentModel>>
    suspend fun getCurriculumRecent(): Result<CurriculumRecentModel>
    suspend fun getTeamMatch(): Result<List<TeamMatchingModel>>
    suspend fun getMemberInfoDetail(): Result<MemberInfoDetailModel>
    suspend fun getMemberInfoList(teamId: Int): Result<List<ProfileModel>>
    suspend fun getAttendCurrentList(): Result<List<AttendCurrentModel>>
    suspend fun getAttendInfo(): Result<AttendInfoModel>
    suspend fun getAttendScore(): Result<AttendModel>
    suspend fun getAttendQrText(curriculumId: Int): Result<AttendQRModel>
    suspend fun postAttendCheck(curriculumId: Int, qrText: String): Result<Unit>
}