package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.request.CommentContentRequestBody
import com.kusitms.data.remote.entity.request.ReportCommentRequestBody
import com.kusitms.data.remote.entity.response.LoginMemberProfileResponse
import com.kusitms.data.remote.entity.response.LoginResponse
import com.kusitms.data.remote.entity.response.notice.CommentPayload
import com.kusitms.data.remote.entity.response.notice.CurriculumPayload
import com.kusitms.data.remote.entity.response.notice.NoticePayload
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
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

    @GET("notice/{noticeId}/detail")
    suspend fun getNoticeDetail(
        @Path("noticeId") noticeId : Int
    ) : BaseResponse<NoticePayload>

    @GET("notice/curriculum")
    suspend fun getCurriculumList(): BaseResponse<List<CurriculumPayload>>

    @GET("notice/curriculum/list")
    suspend fun getGetCurriculumNoticeList(
        @Query("curriculumId") curriculumId : Int
    ) : BaseResponse<List<NoticePayload>>

    @GET("comment/{noticeId}")
    suspend fun getNoticeCommentList(
        @Path("noticeId") noticeId : Int
    ) : BaseResponse<List<CommentPayload>>

    @POST("comment/{noticeId}")
    suspend fun addNoticeComment(
        @Path("noticeId") noticeId : Int,
        @Body commentContentRequestBody: CommentContentRequestBody
    ) : BaseResponse<CommentPayload>

    @DELETE("comment/{commentId}")
    suspend fun deleteNoticeComment(
        @Path("commentId") commentId : Int
    ) : BaseResponse<Unit>

    @POST("report")
    suspend fun reportComment(
        @Body reportCommentRequestBody: ReportCommentRequestBody
    ) : BaseResponse<Unit>
}