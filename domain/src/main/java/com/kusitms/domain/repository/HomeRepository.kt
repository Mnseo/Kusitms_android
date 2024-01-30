package com.kusitms.domain.repository

import com.kusitms.domain.model.home.CurriculumRecentModel
import com.kusitms.domain.model.home.HomeProfileModel
import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.model.home.NoticeRecentModel
import com.kusitms.domain.model.home.TeamMatchingModel
import com.kusitms.domain.model.home.TeamProfileModel

interface HomeRepository {
    suspend fun getMemberInfoHome(): Result<HomeProfileModel>
    suspend fun getNoticeRecent(): Result<List<NoticeRecentModel>>
    suspend fun getCurriculumRecent(): Result<CurriculumRecentModel>
    suspend fun getTeamMatch(): Result<List<TeamMatchingModel>>
    suspend fun getMemberInfoDetail(): Result<MemberInfoDetailModel>
    suspend fun getMemberInfoList(
        teamId: Int
    ): Result<List<TeamProfileModel>>
}