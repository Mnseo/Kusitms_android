package com.kusitms.presentation.ui.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.usecase.notice.GetCurriculumListUseCase
import com.kusitms.domain.usecase.notice.GetNoticeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeViewModel @Inject constructor(
    private val getNoticeListUseCase: GetNoticeListUseCase,
    getCurriculumListUseCase: GetCurriculumListUseCase
) : ViewModel() {

    private val _noticeList = MutableStateFlow<List<NoticeModel>>(emptyList())
    val noticeList : StateFlow<List<NoticeModel>> = _noticeList.asStateFlow()

   init {
       viewModelScope.launch {
           getNoticeListUseCase().catch {

           }.collect {
               _noticeList.emit(it)
           }
       }

   }

    val curriculumList = getCurriculumListUseCase().catch {

    }.stateIn(
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

    fun updateNoticeAsViewedInList(noticeId : Int){
        viewModelScope.launch {
            _noticeList.emit(
                noticeList.value.map {
                    if(it.noticeId == noticeId && !it.viewYn) it.copy(viewYn = true)
                    else it
                }
            )
        }
    }
}