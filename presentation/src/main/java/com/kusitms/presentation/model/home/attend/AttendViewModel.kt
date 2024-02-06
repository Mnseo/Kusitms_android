package com.kusitms.presentation.model.home.attend

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.kusitms.domain.model.home.AttendCurrentModel
import com.kusitms.domain.model.home.AttendInfoModel
import com.kusitms.domain.model.home.AttendModel
import com.kusitms.domain.usecase.home.GetAttendCurrentListUseCase
import com.kusitms.domain.usecase.home.GetAttendInfoUseCase
import com.kusitms.domain.usecase.home.GetAttendScoreUseCase
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Year
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*
import javax.inject.Inject


@HiltViewModel
class AttendViewModel @Inject constructor(
    getAttendCurrentListUseCase: GetAttendCurrentListUseCase,
    getAttendInfoUseCase: GetAttendInfoUseCase,
    getAttendScoreUseCase: GetAttendScoreUseCase
):ViewModel() {

    val attendListInit = getAttendCurrentListUseCase().catch {
    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    val upcomingAttend = getAttendInfoUseCase().catch {
    }.stateIn(
        viewModelScope,
        started =  SharingStarted.Eagerly,
        initialValue = AttendInfoModel(0, "", false, "", "")
    )

    val attendScore = getAttendScoreUseCase().catch {
    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = AttendModel(0, 0, 0, 0, "수료 가능한 점수에요")
    )

    private val _attendCurrentList = MutableStateFlow<List<AttendCurrentModel>>(emptyList())
    val attendCurrentList : StateFlow<List<AttendCurrentModel>> = _attendCurrentList.asStateFlow()

    private val _eventDateTime = MutableStateFlow<LocalDateTime?>(null)
    val eventDateTime: StateFlow<LocalDateTime?> = _eventDateTime

    private val _attendScore = MutableStateFlow(
        AttendModel(penalty = 0, present = 0, absent = 0, late = 0, passYn = "수료 가능한 점수에요")
    )

    fun formatDate(dateString: String): String {
        val originalFormat = SimpleDateFormat("MM월 dd일", Locale.KOREA)
        val targetFormat = SimpleDateFormat("M월 d일", Locale.KOREA)
        return try {
            val parsedDate = originalFormat.parse(dateString)
            parsedDate?.let { targetFormat.format(it) } ?: dateString
        } catch (e: Exception) {
            // 파싱에 실패시, 원본 날짜를 그대로 사용
            dateString
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun combineDateAndTime(date: String, time: String): LocalDateTime? {
        val currentYear = LocalDate.now().year
        // 날짜 형식에 연도 추가
        val dateFormatter = DateTimeFormatter.ofPattern("MM월 dd일", Locale.KOREAN)
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh:mm", Locale.KOREAN)

        return try {
            // 날짜와 시간 문자열을 현재 연도와 결합
            val dateTimeStr = "${currentYear}년 $date $time"
            LocalDateTime.parse(dateTimeStr, dateTimeFormatter)
        } catch (e: Exception) {
            null // 파싱 실패 시 null 반환
        }
    }

    init {
        viewModelScope.launch {
            getAttendCurrentListUseCase().catch {

            }.collect() {
                _attendCurrentList.value = it.map { attendModel ->
                    attendModel.copy(date = formatDate(attendModel.date))
                }
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