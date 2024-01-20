package com.kusitms.presentation.model.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {
    private val initNotice: Int = 0
    private val _uiState = MutableStateFlow(HomeUiState(initNotice))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {

    }

    fun changeCurrentNotice(noticeId: Int) {
        _uiState.value = _uiState.value.copy(currentNotice = noticeId)
    }
}