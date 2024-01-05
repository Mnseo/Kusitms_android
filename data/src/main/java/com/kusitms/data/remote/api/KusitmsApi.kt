package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.nullExceptionResponse
import com.kusitms.data.remote.entity.request.CommentContentRequestBody
import com.kusitms.data.remote.entity.request.UpdatePasswordRequest
import com.kusitms.data.remote.entity.response.CheckPasswordPayload
import com.kusitms.data.remote.entity.response.FindPwCheckEmailResponse
import com.kusitms.data.remote.entity.request.ReportCommentRequestBody
import com.kusitms.data.remote.entity.response.LoginMemberProfileResponse
import com.kusitms.data.remote.entity.response.LoginResponse
import com.kusitms.data.remote.entity.response.SignInRequestResponse
import com.kusitms.data.remote.entity.response.notice.CommentPayload
import com.kusitms.data.remote.entity.response.notice.CurriculumPayload
import com.kusitms.data.remote.entity.response.notice.FindPwCodeVerifyResponse
import com.kusitms.data.remote.entity.response.notice.NoticePayload
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface KusitmsApi {
    @GET("auth/login/MEMBER")
    suspend fun loginMember(
        @Query("email") email: String,
        @Query("password") password: String
    ): LoginResponse

    @Multipart
    @POST("member")
    suspend fun sendAdditionalProfile(
        @Part("dto") dto: RequestBody,
        @Part file: MultipartBody.Part
    ): nullExceptionResponse<Unit>


    @GET("member/info")
    suspend fun loginMemberProfile(): LoginMemberProfileResponse

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
    ) : Response<BaseResponse<Unit>>

    // SignInNonMember
    @FormUrlEncoded
    @POST("member/check/register")
    suspend fun signInRequestCheck(
        @Field("email") email: String,
        @Field("password") password: String
    ): SignInRequestResponse

    @FormUrlEncoded
    @POST("member/register")
    suspend fun signInRequest(
        @Field("email") email: String,
        @Field("password") password: String
    ): BaseResponse<Unit>

    // FindPw
    @FormUrlEncoded
    @POST("member/email")
    suspend fun verifyEmailCheck(
        @Field("email") email: String
    ): FindPwCheckEmailResponse

    @FormUrlEncoded
    @POST("member/verify")
     suspend fun sendCode(
        @Field("email") email: String
    ): BaseResponse<Unit>

    @FormUrlEncoded
    @POST("member/verify/code")
    suspend fun verifyCode(
        @Field("email") email: String,
        @Field("code") code:String
    ): FindPwCodeVerifyResponse

    @PUT("member/password/unauthenticated")
    suspend fun updatePassword(
        @Query("email") email: String,
        @Body passwordRequest: UpdatePasswordRequest
    ): BaseResponse<Unit>


    @POST("member/password")
    suspend fun checkPassword(
        @Query("password") password: String
    ) : BaseResponse<CheckPasswordPayload>

    @PUT("member/password")
    suspend fun updatePasswordAsLoggedIn(
        @Body passwordRequest: UpdatePasswordRequest
    ) : BaseResponse<Unit>

    //로그아웃 및 탈퇴
    @DELETE("auth/logout")
    suspend fun logOutMember(): BaseResponse<Unit>

    @DELETE("member")
    suspend fun signOutMember(): BaseResponse<Unit>



}