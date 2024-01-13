package com.kusitms.presentation.ui.profile.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.usecase.profile.GetProfileDetailUseCase
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
) : ViewModel() {
    val memberId: Int = savedStateHandle.get<Int>(PROFILE_ID_SAVED_STATE_KEY) ?: 22

    val profile = getProfileDetailUseCase(memberId).catch {

    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ProfileModel()
    )

    companion object {
        private const val PROFILE_ID_SAVED_STATE_KEY = "memberId"
    }


}