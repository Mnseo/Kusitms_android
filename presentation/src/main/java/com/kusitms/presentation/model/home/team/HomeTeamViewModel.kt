package com.kusitms.presentation.model.home.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.home.GetTeamProfileListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeTeamViewModel @Inject constructor(
    getTeamProfileListUseCase: GetTeamProfileListUseCase,
) : ViewModel() {
    val teamMatch = getTeamProfileListUseCase(1).catch {

    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )
}