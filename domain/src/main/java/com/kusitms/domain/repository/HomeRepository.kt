package com.kusitms.domain.repository

import com.kusitms.domain.model.home.CurriculumRecentModel
import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.model.home.NoticeRecentModel
import com.kusitms.domain.model.home.TeamMatchingModel

interface HomeRepository {
    suspend fun getMemberInfoDetail(): Result<MemberInfoDetailModel>
    suspend fun getNoticeRecent(): Result<List<NoticeRecentModel>>
    suspend fun getCurriculumRecent(): Result<CurriculumRecentModel>
    suspend fun getTeamMatch(): Result<List<TeamMatchingModel>>
}