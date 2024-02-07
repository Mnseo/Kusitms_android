package com.kusitms.presentation.model.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.usecase.home.GetMemberInfoDetailUseCase
import com.kusitms.domain.usecase.signin.GetLoginMemberProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyProfileViewModel @Inject constructor(
    private val getInfoMemberUseCase: GetLoginMemberProfileUseCase,
    private val getMemberInfoDetailUseCase: GetMemberInfoDetailUseCase,
) : ViewModel() {
    private val _infoProfile = MutableStateFlow(LoginMemberProfile("", "", "", "", false))
    val infoProfile: StateFlow<LoginMemberProfile> = _infoProfile

    private val _detailMemberInfo = MutableStateFlow(MemberInfoDetailModel("", "", listOf(), "", "", listOf()))
    val detailMemberInfo: StateFlow<MemberInfoDetailModel> = _detailMemberInfo


    init {
        getUserProfile()
        getMemberInfoDetail()
    }


    private fun getUserProfile() {
        viewModelScope.launch {
            val profileResult = getInfoMemberUseCase.fetchLoginMemberProfile()
            if (profileResult.isSuccess) {
                _infoProfile.value = profileResult.getOrNull()!!
            }
        }
    }

    private fun getMemberInfoDetail() {
        viewModelScope.launch {
            val profileResult = getMemberInfoDetailUseCase.fetchLoginMemberProfile()
            if (profileResult.isSuccess) {
                _detailMemberInfo.value = profileResult.getOrNull()!!
            }
        }
    }

}