package com.kusitms.presentation.model.profile

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.kusitms.presentation.model.profile.ProfileContract.ProfileViewState
import com.kusitms.presentation.model.profile.ProfileContract.ProfileEvent
import com.kusitms.presentation.model.profile.ProfileContract.ProfileSideEffect
import com.kusitms.presentation.common.base.BaseViewModel
import com.kusitms.presentation.common.base.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(): BaseViewModel<ProfileViewState, ProfileSideEffect, ProfileEvent>(
    ProfileViewState()
) {
    override fun handleEvents(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OnPartToggleClicked -> {
                openToggle()
                sendEffect({ ProfileSideEffect.OpenPartToggle })
            }
        }
    }

    private fun openToggle() {
        Log.d("프로필", "토글 클릭")
    }
}