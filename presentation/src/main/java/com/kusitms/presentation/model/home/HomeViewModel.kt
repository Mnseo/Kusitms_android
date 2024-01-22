package com.kusitms.presentation.model.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.model.home.NoticeRecentModel
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.usecase.home.GetMemberInfoDetailUseCase
import com.kusitms.domain.usecase.signin.GetLoginMemberProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getInfoMemberUseCase: GetLoginMemberProfileUseCase,
    getMemberInfoDetailUseCase: GetMemberInfoDetailUseCase,
) : ViewModel() {
    private val initNotice: Int = 0
    private val transitionDuration = 200L

    private var _infoProfile: LoginMemberProfile = LoginMemberProfile("", "", "", "", false)
    var infoProfile: LoginMemberProfile = _infoProfile

    val detailMemberInfo = getMemberInfoDetailUseCase().catch {
    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = MemberInfoDetailModel()
    )

    val _notices = mutableListOf(
        NoticeRecentModel("공지 0", 0),
        NoticeRecentModel("공지 1", 1),
        NoticeRecentModel("공지 2", 2),
    )

    private val _uiState = MutableStateFlow(HomeUiState(initNotice))

    private var _isTransitioning = MutableStateFlow(false)

    private var _currentNoticeIndex = MutableStateFlow(0)
    var currentNoticeIndex: StateFlow<Int> = _currentNoticeIndex.asStateFlow()

    private var _nextNoticeIndex = MutableStateFlow(1)
    var nextNoticeIndex: StateFlow<Int> = _nextNoticeIndex.asStateFlow()

    init {
        getUserProfile()
        changeCurrentNotice()
    }

    private fun getUserProfile() {
        viewModelScope.launch {
            val profileResult = getInfoMemberUseCase.fetchLoginMemberProfile()
            if (profileResult.isSuccess) {
                _infoProfile = profileResult.getOrNull()!!
                infoProfile = _infoProfile
            }
        }
    }

    private fun changeCurrentNotice() {
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