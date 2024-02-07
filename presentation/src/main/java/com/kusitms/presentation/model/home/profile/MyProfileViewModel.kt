package com.kusitms.presentation.model.home.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.usecase.home.GetMemberInfoDetailUseCase
import com.kusitms.domain.usecase.signin.GetLoginMemberProfileUseCase
import com.kusitms.presentation.model.profile.detail.ProfileDetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyProfileViewModel @Inject constructor(
    private val getInfoMemberUseCase: GetLoginMemberProfileUseCase,
    getMemberInfoDetailUseCase: GetMemberInfoDetailUseCase,
) : ViewModel() {
    private var _infoProfile: LoginMemberProfile = LoginMemberProfile("", "", "", "", false)
    var infoProfile: LoginMemberProfile = _infoProfile

    val detailMemberInfo = getMemberInfoDetailUseCase().catch {

    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = MemberInfoDetailModel()
    )

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


}