package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.response.LoginMemberProfileResponse
import com.kusitms.data.remote.entity.response.LoginResponse
import com.kusitms.data.remote.entity.response.notice.CurriculumPayload
import com.kusitms.data.remote.entity.response.notice.NoticePayload
import retrofit2.http.GET
import retrofit2.http.Query


interface KusitmsApi {
    @GET("auth/login/MEMBER")
    suspend fun LoginMember(
        @Query("email") email: String,
        @Query("password") password: String
    ): LoginResponse

    @GET("member/info/detail")
    suspend fun LoginMemberProfile(): LoginMemberProfileResponse

    // 공지사항 -> 차후에 분리하는 것도 좋을 듯 싶습니다.
    @GET("notice")
    suspend fun getNoticeList(): BaseResponse<List<NoticePayload>>

    @GET("notice/curriculum")
    suspend fun getCurriculumList(): BaseResponse<List<CurriculumPayload>>

}