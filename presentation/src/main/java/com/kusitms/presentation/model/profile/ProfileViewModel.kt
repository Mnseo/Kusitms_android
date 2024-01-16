package com.kusitms.presentation.model.profile

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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    getProfileListUseCase: GetProfileListUseCase,
) : ViewModel() {

    val profileListInit = getProfileListUseCase().catch {

    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    private val _profileList = MutableStateFlow<List<ProfileModel>>(emptyList())
    val profileList: StateFlow<List<ProfileModel>> = _profileList.asStateFlow()

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _expanded = MutableStateFlow(false)
    val expended: StateFlow<Boolean> = _expanded.asStateFlow()

    init {
        viewModelScope.launch {
            getProfileListUseCase().catch {

            }.collect {
                _profileList.value = it
            }
        }
    }

    fun changeSelectPart(part: String) {
        _uiState.value = _uiState.value.copy(currentSelectedPart = part)
        _expanded.value = false
        getFilterProfiles()
    }

    fun toggleExpanded() {
        _expanded.value = !_expanded.value
    }

    private fun getFilterProfiles() {
        val selectedPart = uiState.value.currentSelectedPart

        val filteredProfiles = profileListInit.value.filter { profile ->
            mapPartToKorean(profile.part).contains(selectedPart, ignoreCase = true)
        }


        _profileList.value = filteredProfiles
    }

    private fun mapPartToKorean(part: String): String {
        return when (part) {
            "PLANNING" -> "기획팀"
            "DESIGN" -> "디자인팀"
            "DEVELOPMENT" -> "개발팀"
            else -> part
        }
    }
}