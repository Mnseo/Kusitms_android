package com.kusitms.presentation.model.profile.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.usecase.profile.GetProfileListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProfileSearchViewModel @Inject constructor(
    getProfileListUseCase: GetProfileListUseCase,
) : ViewModel() {

    val profileList = getProfileListUseCase().catch {

    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    private val _uiState = MutableStateFlow(ProfileSearchUiState())
    val uiState: StateFlow<ProfileSearchUiState> = _uiState.asStateFlow()


    fun changeSearchText(searchText: String) {
        _uiState.value = _uiState.value.copy(searchText = searchText)
    }

    fun clearSearchText() {
        changeSearchText("")
    }

    // profiles에 검색어가 포함되는지 확인하는 함수
    fun profilesContainsSearchText(searchText: String, profileList: List<ProfileModel>): Boolean {
        return profileList.any { it.name.contains(searchText) }
    }

    fun getSearchProfiles(): List<ProfileModel> {
        return if (uiState.value.searchText.isNotEmpty()) {
            profileList.value.filter { profile ->
                profile.name.contains(uiState.value.searchText, ignoreCase = true)
            }
        } else {
            profileList.value
        }
    }
}