package com.kusitms.data

import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
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
                Result.success(response.payload)
            } else {
                Result.failure(RuntimeException("공지사항 조회 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}