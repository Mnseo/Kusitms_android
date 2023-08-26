package com.kusitms.presentation.model

import android.renderscript.ScriptGroup
import androidx.annotation.StringRes

sealed interface InputState {
    object Empty : InputState
    object Typing : InputState
    object Ok : InputState
    data class Error(@StringRes val message: Int): InputState
}