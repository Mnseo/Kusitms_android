package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.request.CommentContentRequestBody
import com.kusitms.data.remote.entity.request.UpdatePasswordRequest
import com.kusitms.data.remote.entity.response.FindPwCheckEmailResponse
import com.kusitms.data.remote.entity.request.ReportCommentRequestBody
import com.kusitms.data.remote.entity.response.LoginMemberProfileResponse
import com.kusitms.data.remote.entity.response.LoginResponse
import com.kusitms.data.remote.entity.response.SignInRequestResponse
import com.kusitms.data.remote.entity.response.notice.CommentPayload
import com.kusitms.data.remote.entity.response.notice.CurriculumPayload
import com.kusitms.data.remote.entity.response.notice.NoticePayload
import retrofit2.http.*


interface KusitmsApi {
    @GET("auth/login/MEMBER")
    suspend fun LoginMember(
        @Query("email") email: String,
        @Query("password") password: String
    ): LoginResponse

    @GET("auth/reissue")
    suspend fun RefreshAccessToken() : LoginResponse

    @GET("member/info")
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

    @FormUrlEncoded
    @POST("member/check/register")
    suspend fun SignInRequestCheck(
        @Field("email") email: String,
        @Field("password") password: String
    ): SignInRequestResponse

    @FormUrlEncoded
    @POST("member/register")
    suspend fun SignInRequest(
        @Field("email") email: String,
        @Field("password") password: String
    ): BaseResponse<Unit>

    @FormUrlEncoded
    @POST("member/email")
    suspend fun VerifyEmailCheck(
        @Field("email") email: String
    ): FindPwCheckEmailResponse

    @FormUrlEncoded
    @POST("member/verify")
    suspend fun SendCode(
        @Field("email") email: String
    ): BaseResponse<Unit>


    @PUT("v1/member/password/unauthenticated")
    suspend fun updatePassword(
        @Query("email") email: String,
        @Body passwordRequest: UpdatePasswordRequest
    ): BaseResponse<Unit>

    @FormUrlEncoded
    @POST("member/verify/code")
    suspend fun VerifyCode(
        @Field("email") email: String,
        @Field("code") code:String
    ): SignInRequestResponse


}