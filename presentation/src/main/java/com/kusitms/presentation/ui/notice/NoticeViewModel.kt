package com.kusitms.presentation.ui.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.notice.GetCurriculumListUseCase
import com.kusitms.domain.usecase.notice.GetNoticeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeViewModel @Inject constructor(
    getNoticeListUseCase: GetNoticeListUseCase,
    getCurriculumListUseCase: GetCurriculumListUseCase
) : ViewModel() {

    val noticeList = getNoticeListUseCase().stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    val curriculumList = getCurriculumListUseCase().stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    private val _visibleOnlyUnreadNotice = MutableStateFlow(false)
    val visibleOnlyUnreadNotice : StateFlow<Boolean> = _visibleOnlyUnreadNotice.asStateFlow()

    fun updateVisibleOnlyUnreadNotice(isVisible : Boolean){
        viewModelScope.launch {
            _visibleOnlyUnreadNotice.emit(isVisible)
        }
    }
}