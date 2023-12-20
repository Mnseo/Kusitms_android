package com.kusitms.domain.repository

import com.kusitms.domain.model.notice.NoticeModel

interface NoticeRepository {

    suspend fun getNoticeList() : Result<List<NoticeModel>>
}