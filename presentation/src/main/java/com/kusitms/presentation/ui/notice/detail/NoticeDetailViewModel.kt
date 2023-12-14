package com.kusitms.presentation.ui.notice.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.usecase.notice.GetNoticeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NoticeDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getNoticeDetailUseCase: GetNoticeDetailUseCase
) : ViewModel() {

    val noticeId: Int = savedStateHandle.get<Int>(NOTICE_ID_SAVED_STATE_KEY)!!

    val notice = getNoticeDetailUseCase(noticeId).catch {
        //TODO 에러처리
    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = NoticeModel()
    )

    companion object {
        private const val NOTICE_ID_SAVED_STATE_KEY = "noticeId"
    }
}