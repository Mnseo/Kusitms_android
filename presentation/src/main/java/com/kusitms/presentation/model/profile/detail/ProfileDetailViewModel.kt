package com.kusitms.presentation.model.profile.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.usecase.home.GetMemberInfoDetailUseCase
import com.kusitms.domain.usecase.profile.GetProfileDetailUseCase
import com.kusitms.domain.usecase.signin.GetLoginMemberProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getProfileDetailUseCase: GetProfileDetailUseCase,
    private val getInfoMemberUseCase: GetLoginMemberProfileUseCase,
) : ViewModel() {
    val memberId: Int = savedStateHandle.get<Int>(PROFILE_ID_SAVED_STATE_KEY)!!

    val profile = getProfileDetailUseCase(memberId).catch {
    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ProfileModel()
    )

    private var _infoProfile: LoginMemberProfile = LoginMemberProfile("", "", "", "", false)
    var infoProfile: LoginMemberProfile = _infoProfile

    init {
        getUserProfile()
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

    companion object {
        private const val PROFILE_ID_SAVED_STATE_KEY = "memberId"
    }
}