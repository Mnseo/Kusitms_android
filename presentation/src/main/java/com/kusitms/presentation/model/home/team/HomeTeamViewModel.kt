package com.kusitms.presentation.model.home.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.usecase.home.GetTeamProfileListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeTeamViewModel @Inject constructor(
    getTeamProfileListUseCase: GetTeamProfileListUseCase,
) : ViewModel() {

    private val _profileList = MutableStateFlow<List<ProfileModel>>(emptyList())
    val profileList: StateFlow<List<ProfileModel>> = _profileList.asStateFlow()

    init {
        viewModelScope.launch {
            getTeamProfileListUseCase(1).catch {

            }.collect {
                _profileList.value = it
            }
        }
    }
}