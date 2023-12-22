package com.kusitms.presentation.model.profile

import com.kusitms.presentation.common.base.LoadState
import com.kusitms.presentation.common.base.ViewEvent
import com.kusitms.presentation.common.base.ViewSideEffect
import com.kusitms.presentation.common.base.ViewState

class ProfileContract {
    data class ProfileViewState(
        val loadState: LoadState = LoadState.SUCCESS,
        val partState: PartState = PartState.NONE,
        val isPartListVisible: Boolean = false
    ) : ViewState

    sealed class ProfileSideEffect : ViewSideEffect {
        object OpenPartToggle : ProfileSideEffect()
    }

    sealed class ProfileEvent : ViewEvent {
//        object InitProfileScreen : ProfileEvent()
        object OnPartToggleClicked : ProfileEvent()
    }

    enum class PartState {
        NONE, PLAN, DEV, DESIGN
    }
}