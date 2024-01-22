package com.kusitms.presentation.model.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kusitms.domain.model.home.NoticeRecentModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {
    private val initNotice: Int = 0
    private val transitionDuration = 200L

    val _notices = mutableListOf(
        NoticeRecentModel("공지 0", 0),
        NoticeRecentModel("공지 1", 1),
        NoticeRecentModel("공지 2", 2),
    )

    private val _uiState = MutableStateFlow(HomeUiState(initNotice))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private var _isTransitioning = MutableStateFlow(false)
    var isTransitioning: StateFlow<Boolean> = _isTransitioning.asStateFlow()

    private var _currentNoticeIndex = MutableStateFlow(0)
    var currentNoticeIndex: StateFlow<Int> = _currentNoticeIndex.asStateFlow()

    private var _nextNoticeIndex = MutableStateFlow(1)
    var nextNoticeIndex: StateFlow<Int> = _nextNoticeIndex.asStateFlow()

    init {
        changeCurrentNotice()
    }

    fun changeCurrentNotice() {
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            while (true) {
                delay(3000)
                _isTransitioning.value = true
                delay(100)
                _currentNoticeIndex.value = _nextNoticeIndex.value
                _nextNoticeIndex.value = (_currentNoticeIndex.value + 1) % _notices.size
                _uiState.value = HomeUiState(_notices[_currentNoticeIndex.value].noticeId)
                delay(transitionDuration)
                _isTransitioning.value = false
            }
        }
    }
}