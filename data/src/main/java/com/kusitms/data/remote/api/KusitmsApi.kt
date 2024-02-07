package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.request.*
import com.kusitms.data.remote.entity.response.CheckPasswordPayload
import com.kusitms.data.remote.entity.response.FindPwCheckEmailResponse
import com.kusitms.data.remote.entity.response.LoginMemberProfileResponse
import com.kusitms.data.remote.entity.response.LoginResponse
import com.kusitms.data.remote.entity.response.SignInRequestResponse
import com.kusitms.data.remote.entity.response.home.*
import com.kusitms.data.remote.entity.response.notice.CommentPayload
import com.kusitms.data.remote.entity.response.notice.CurriculumPayload
import com.kusitms.data.remote.entity.response.notice.FindPwCodeVerifyResponse
import com.kusitms.data.remote.entity.response.notice.NoticeDetailPayload
import com.kusitms.data.remote.entity.response.notice.NoticePayload
import com.kusitms.data.remote.entity.response.notice.NoticeVotePayload
import com.kusitms.data.remote.entity.response.profile.ProfilePayload
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface KusitmsApi {
    @POST("v1/auth/login/MEMBER")
    suspend fun loginMember(
        @Body loginRequestBody: LoginRequestBody
    ): LoginResponse

    @Multipart
    @POST("v1/member")
    suspend fun sendAdditionalProfile(
        @Part("dto") dto: RequestBody,
        @Part file: MultipartBody.Part,
    ): Response<BaseResponse<Unit?>?>


    @GET("v1/member/info")
    suspend fun loginMemberProfile(): LoginMemberProfileResponse

    // 사용자 상세 정보 조회
    @GET("v1/member/info/detail")
    suspend fun getMemberInfoDetail(): BaseResponse<MemberInfoDetailPayload>

    // 홈 화면 사용자 정보 조회
    @GET("v1/member/info/home")
    suspend fun getMemberInfoHome(): BaseResponse<HomeProfilePayload>

    // 최신 공지 조회
    @GET("v1/notice/recent")
    suspend fun getNoticeRecent(): BaseResponse<List<NoticeRecentPayload>>

    // 최신 커리큘럼 조회
    @GET("v1/curriculum/recent")
    suspend fun getCurriculumRecent(): BaseResponse<CurriculumRecentPayload>

    // 홈 화면 팀 매칭 조회
    @GET("v1/team/match")
    suspend fun getTeamMatch(): BaseResponse<List<TeamMatchingPayload>>

    // 매칭된 팀 정보 조회
    @GET("v1/member/info/list/{teamId}")
    suspend fun getMemberInfoList(
        @Path("teamId") teamId: Int,
        ): BaseResponse<List<TeamProfilePayload>>

    // 공지사항 -> 차후에 분리하는 것도 좋을 듯 싶습니다.
    @GET("v2/notice")
    suspend fun getNoticeList(
        @Query("cursor") cursor : Int? = null,
        @Query("size") size : Int = 30
    ): BaseResponse<List<NoticePayload>>

    @GET("v2/notice/{noticeId}/detail")
    suspend fun getNoticeDetail(
        @Path("noticeId") noticeId: Int,
    ): BaseResponse<NoticeDetailPayload>

    @GET("v1/notice/curriculum")
    suspend fun getCurriculumList(): BaseResponse<List<CurriculumPayload>>

    @GET("v1/notice/curriculum/list")
    suspend fun getGetCurriculumNoticeList(
        @Query("curriculumId") curriculumId: Int,
    ): BaseResponse<List<NoticePayload>>

    @GET("v1/comment/{noticeId}")
    suspend fun getNoticeCommentList(
        @Path("noticeId") noticeId: Int,
    ): BaseResponse<List<CommentPayload>>

    @POST("v1/comment/{noticeId}")
    suspend fun addNoticeComment(
        @Path("noticeId") noticeId: Int,
        @Body commentContentRequestBody: CommentContentRequestBody,
    ): BaseResponse<CommentPayload>

    @DELETE("v1/comment/{commentId}")
    suspend fun deleteNoticeComment(
        @Path("commentId") commentId: Int,
    ): BaseResponse<Unit>

    @POST("v1/report")
    suspend fun reportComment(
        @Body reportCommentRequestBody: ReportCommentRequestBody,
    ): Response<BaseResponse<Unit>>

    @GET("v1/comment/child/{commentId}")
    suspend fun getChildCommentList(
        @Path("commentId") commentId: Int,
    ): BaseResponse<List<CommentPayload>>

    @POST("v1/comment/{noticeId}/{commentId}")
    suspend fun addNoticeChildComment(
        @Path("noticeId") noticeId: Int,
        @Path("commentId") commentId: Int,
        @Body commentContentRequestBody: CommentContentRequestBody,
    ): BaseResponse<CommentPayload>

    //vote
    @GET("v1/vote")
    suspend fun getNoticeVote(
        @Query("noticeId") noticeId: Int,
    ): BaseResponse<NoticeVotePayload>

    @POST("v1/vote/attend")
    suspend fun voteNoticeItem(
        @Query("voteItemId") voteItemId: Int,
    ): BaseResponse<Int>


    // SignInNonMember (회원가입 가능 체크)
    @FormUrlEncoded
    @POST("v1/member/check/register")
    suspend fun signInRequestCheck(
        @Body loginRequestBody: LoginRequestBody
    ): SignInRequestResponse

    @FormUrlEncoded //회원가입
    @POST("v1/member/register")
    suspend fun signInRequest(
        @Body loginRequestBody: LoginRequestBody
    ): BaseResponse<Unit>

    // FindPw
    @FormUrlEncoded
    @POST("v1/member/email") //이메일 존재 확인
    suspend fun verifyEmailCheck(
        @Body checkEmailRequestBody: CheckEmailRequestBody
    ): FindPwCheckEmailResponse

    @FormUrlEncoded
    @POST("v1/member/verify")
    suspend fun sendCode(
        @Body checkEmailRequestBody: CheckEmailRequestBody
    ): BaseResponse<Unit>

    @FormUrlEncoded
    @POST("v1/member/verify/code") //이메일 코드 검증
    suspend fun verifyCode(
        @Body emailVerifyRequestBody: EmailVerifyRequestBody
    ): FindPwCodeVerifyResponse

    @PUT("v1/member/password/unauthenticated")
    suspend fun updatePassword(
        @Query("email") email: String,
        @Body passwordRequest: UpdatePasswordRequest,
    ): BaseResponse<Unit>


    @POST("v1/member/password")
    suspend fun checkPassword(
        @Body passwordRequestBody: PasswordRequestBody
    ): BaseResponse<CheckPasswordPayload>

    @PUT("v1/member/password")
    suspend fun updatePasswordAsLoggedIn(
        @Body passwordRequest: UpdatePasswordRequest,
    ): BaseResponse<Unit>

    //로그아웃 및 탈퇴
    @DELETE("v1/auth/logout")
    suspend fun logOutMember(): BaseResponse<Unit>

    @DELETE("v1/member")
    suspend fun signOutMember(): BaseResponse<Unit>


    // 프로필 리스트
    @GET("v1/member/info/list")
    suspend fun getInfoListMember(): BaseResponse<List<ProfilePayload>>

    // 프로필 상세 조회
    @GET("v1/member/info/{memberId}")
    suspend fun getProfileDetail(
        @Path("memberId") memberId: Int,
    ): BaseResponse<ProfilePayload>


    //이번주 커리큘럼 조회
    @GET("v1/attend/info")
    suspend fun getAttendInfo(): BaseResponse<AttendInfoPayload>

    //커리큘럼 출석 조회
    @GET("v1/attend/lists")
    suspend fun getAttendCurrentList(): BaseResponse<List<AttendCurrentPayLoad>>

    //출석 정보 조회
    @GET("v1/attend")
    suspend fun getAttendScore(): BaseResponse<AttendPayload>

    //출석 QR 조회
    @GET("v1/attend/text/{curriculumId}")
    suspend fun getQrText(
        @Path("curriculumId") curriculumId: Int
    ):BaseResponse<AttendQrTextPayload>

    //결석 처리
    @POST("v1/attend/absent/{curriculumId}")
    suspend fun postAbsent(
        @Path("curriculumId") curriculumId: Int
    ): BaseResponse<Unit>

    //출석 처리
    @POST("v1/attend")
    suspend fun attendCheck(
        @Body attendCheckRequestBody: AttendCheckRequestBody
    ): BaseResponse<Unit>
}