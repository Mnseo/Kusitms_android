package com.kusitms.presentation.model.home.attend

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.kusitms.domain.model.home.AttendCurrentModel
import com.kusitms.domain.model.home.AttendModel
import com.kusitms.domain.usecase.home.GetAttendCurrentListUseCase
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AttendViewModel @Inject constructor(
    getAttendCurrentListUseCase: GetAttendCurrentListUseCase
):ViewModel() {

    val attendListInit = getAttendCurrentListUseCase().catch {
    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    private val _attendCurrentList = MutableStateFlow<List<AttendCurrentModel>>(emptyList())
    val attendCurrentList : StateFlow<List<AttendCurrentModel>> = _attendCurrentList.asStateFlow()

    private val _attendScore = MutableStateFlow(
        AttendModel(penalty = 0, present = 0, absent = 0, late = 0, passYn = "수료 가능한 점수에요")
    )
    val attendScore: StateFlow<AttendModel> = _attendScore.asStateFlow()

    fun updateAttendScore(attendModel: AttendModel) {
        _attendScore.value = attendModel
    }

    init {
        viewModelScope.launch {
            getAttendCurrentListUseCase().catch {

            }.collect() {
                _attendCurrentList.value = it
            }
        }
    }


    enum class Status(val displayName: String) {
        PRESENT("출석"),
        ABSENT("결석"),
        LATE("지각");

        companion object {
            fun fromString(status: String): Status? {
                return values().find { it.displayName == status }
            }
        }

        fun toDrawable(): Int {
            return when (this) {
                PRESENT -> R.drawable.ic_attend_check
                ABSENT -> R.drawable.ic_attend_non_check
                LATE -> R.drawable.ic_attend_late
            }
        }
    }


}