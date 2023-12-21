package com.kusitms.data

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.response.notice.toModel
import com.kusitms.domain.model.notice.CurriculumModel
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.repository.NoticeRepository
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
) : NoticeRepository {
    override suspend fun getNoticeList(): Result<List<NoticeModel>> {
        return try {
            val response = kusitmsApi.getNoticeList()
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

    override suspend fun getCurriculumList(): Result<List<CurriculumModel>> {
        return try {
            val response = kusitmsApi.getCurriculumList()
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.map { it.toModel() })
            } else {
                Result.failure(RuntimeException("커리큘럼 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}