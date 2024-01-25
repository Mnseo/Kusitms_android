package com.kusitms.data.repository

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.request.toBody
import com.kusitms.data.remote.entity.response.notice.toModel
import com.kusitms.domain.model.notice.CommentContentModel
import com.kusitms.domain.model.notice.CommentModel
import com.kusitms.domain.model.notice.CurriculumModel
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.NoticeVoteModel
import com.kusitms.domain.model.notice.ReportCommentContentModel
import com.kusitms.domain.model.report.ReportResult
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
) : NoticeRepository {
    override suspend fun getNoticeList(): Result<List<NoticeModel>> {
        return try {
            val response = kusitmsApi.getNoticeList(size = 30)
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.map { it.toModel() })
            } else {
                Result.failure(RuntimeException("공지사항 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getNoticeDetail(noticeId: Int): Result<NoticeModel> {
        return try {
            val response = kusitmsApi.getNoticeDetail(noticeId)
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("공지사항 상세 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getCurriculumList(): Result<List<CurriculumModel>> = withContext(Dispatchers.IO) {
        try {
            val response = kusitmsApi.getCurriculumList()
            if (response.result.code == 200 && response.payload != null) {
                Result.success(
                    response.payload.map { it.toModel() }.let { curriculumList ->
                        curriculumList.map { curriculum ->
                            async {
                                getCurriculumNoticeList(curriculumId = curriculum.curriculumId)
                            }
                        }.awaitAll().zip(curriculumList) { noticeList, curriculum ->
                            curriculum.copy(
                                curriculumNoticeList = noticeList
                            )
                        }
                    }
                )
            } else {
                Result.failure(RuntimeException("커리큘럼 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getCurriculumNoticeList(curriculumId : Int): List<NoticeModel> {
        return try {
            val response = kusitmsApi.getGetCurriculumNoticeList(curriculumId)
            if (response.result.code == 200 && response.payload != null) {
                response.payload.map { it.toModel() }
            } else {
                emptyList()
            }
        } catch (e: Exception){
            emptyList()
        }
    }

    override suspend fun getNoticeCommentList(noticeId: Int): Result<List<CommentModel>> {
        return try {
            val response = kusitmsApi.getNoticeCommentList(noticeId)
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.map { it.toModel() })
            } else {
                Result.failure(RuntimeException("공지사항 댓글 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun addNoticeComment(
        noticeId: Int,
        commentContentModel: CommentContentModel
    ): Result<CommentModel> {
        return try {
            val response = kusitmsApi.addNoticeComment(
                noticeId = noticeId,
                commentContentRequestBody = commentContentModel.toBody()
            )
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("댓글 등록 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun deleteNoticeComment(commentId: Int): Result<Unit> {
        return try {
            val response = kusitmsApi.deleteNoticeComment(
                commentId = commentId
            )
            if (response.result.code == 200 && response.payload != null) {
                Result.success(Unit)
            }else {
                Result.failure(RuntimeException("댓글 등록 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun reportComment(reportCommentContentModel: ReportCommentContentModel): Result<ReportResult> {
        return try {
            val response = kusitmsApi.reportComment(
                reportCommentContentModel.toBody()
            )
            if (response.code() == 200) {
                Result.success(ReportResult.SUCCESS)
            }else if(response.code() == 201){
                Result.success(ReportResult.ALREADY_REPORTED)
            }else {
                Result.failure(RuntimeException("댓글 신고 실패: ${response.message()}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getChildCommentList(commentId: Int): Result<List<CommentModel>> {
        return try {
            val response = kusitmsApi.getChildCommentList(commentId)
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.map { it.toModel() })
            } else {
                Result.failure(RuntimeException("대댓글 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun addNoticeChildComment(
        noticeId: Int,
        commentId: Int,
        commentContentModel: CommentContentModel
    ): Result<CommentModel> {
        return try {
            val response = kusitmsApi.addNoticeChildComment(
                noticeId = noticeId,
                commentId = commentId,
                commentContentRequestBody = commentContentModel.toBody()
            )
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("대댓글 등록 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getNoticeVote(noticeId: Int): Result<NoticeVoteModel> {
        return try {
            val response = kusitmsApi.getNoticeVote(
                noticeId = noticeId
            )
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("투표 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun voteNoticeItem(voteItemId: Int): Result<Int>  {
        return try {
            val response = kusitmsApi.voteNoticeItem(
                voteItemId = voteItemId
            )
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload)
            } else {
                Result.failure(RuntimeException("투표 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}