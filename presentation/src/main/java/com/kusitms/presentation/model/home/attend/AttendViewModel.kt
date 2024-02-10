package com.kusitms.presentation.model.home.attend

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.kusitms.domain.model.home.AttendCheckModel
import com.kusitms.domain.model.home.AttendCurrentModel
import com.kusitms.domain.model.home.AttendInfoModel
import com.kusitms.domain.model.home.AttendModel
import com.kusitms.domain.usecase.home.*
import com.kusitms.domain.usecase.signin.GetIsLoginUseCase
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.ui.notice.detail.NoticeDetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Year
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit
import java.util.*
import javax.inject.Inject


@HiltViewModel
class AttendViewModel @Inject constructor(
    private val getAttendCurrentListUseCase: GetAttendCurrentListUseCase,
    private val getAttendInfoUseCase: GetAttendInfoUseCase,
    private val getAttendScoreUseCase: GetAttendScoreUseCase,
    getAttendQrUseCase: GetAttendQrUseCase,
    private val PostAttendCheckUseCase: PostAttendCheckUseCase
):ViewModel() {

    private val _attendListInit =  MutableStateFlow<List<AttendCurrentModel>>(emptyList())
    val attendListInit : StateFlow<List<AttendCurrentModel>> = _attendListInit.asStateFlow()

    private val _upcomingAttend =  MutableStateFlow(AttendInfoModel(0, "커리큘럼이 없습니다", false, ""))
    val upcomingAttend : StateFlow<AttendInfoModel> = _upcomingAttend.asStateFlow()

    private val _attendScore =  MutableStateFlow(AttendModel(0, 0, 0, 0, "수료 가능한 점수에요"))
    val attendScore : StateFlow<AttendModel> = _attendScore.asStateFlow()

    private val _qrEnabled = MutableStateFlow(true)
    val qrEnabled: StateFlow<Boolean> = _qrEnabled.asStateFlow()

    private val _attendCheckModel = MutableStateFlow(
        AttendCheckModel(curriculumId = upcomingAttend.value.curriculumId, text = "")
    )
    val attendCheckModel = _attendCheckModel.asStateFlow()

    private val _snackbarEvent = MutableSharedFlow<AttendSnackBarEvent>()
    val snackbarEvent : SharedFlow<AttendSnackBarEvent> = _snackbarEvent.asSharedFlow()

    fun getAttendList(){
        viewModelScope.launch {
            getAttendCurrentListUseCase()
                .catch { e ->
                }
                .map { list ->
                    list.map { model ->
                        model.copy(
                            date = formatDate(model.date),
                            time = formatTime(model.time)
                        )
                    }
                }.collect {
                    _attendListInit.value = it
                }
        }
    }

    fun getUpcomingAttend() {
        viewModelScope.launch {
            getAttendInfoUseCase()
                .catch {
                    //TODO 에러처리
                }.collect {
                    _upcomingAttend.emit(it)
                    _attendCheckModel.emit(
                        AttendCheckModel(curriculumId = it.curriculumId, text = it.curriculumName)
                    )
                }
        }
    }

    fun getAttendScore(){
        viewModelScope.launch {
            getAttendScoreUseCase()
                .catch {
                    //TODO 에러처리
                }.collect {
                    _attendScore.emit(it)
                }
        }
    }

    fun updateScannedQrCode(qrText: String) {
        _attendCheckModel.value = _attendCheckModel.value.copy(text = qrText)
    }

    fun formatDate(dateString: String): String {
        val originalFormat = SimpleDateFormat("MM월 dd일", Locale.KOREA)
        val targetFormat = SimpleDateFormat("M월 d일", Locale.KOREA)
        return try {
            val parsedDate = originalFormat.parse(dateString)
            parsedDate?.let { targetFormat.format(it) } ?: dateString
        } catch (e: Exception) {
            Log.d("변환 실패", "date")
            dateString
        }
    }

    fun postAttendCheck() {
        viewModelScope.launch {
            while (isActive) {
                val model = attendCheckModel.value
                if(model.curriculumId != 0) {
                    PostAttendCheckUseCase(curriculumId = model.curriculumId, qrText = model.text)
                        .onFailure{
                            _snackbarEvent.emit(AttendSnackBarEvent.Attend_fail)
                        }
                        .onSuccess {
                            Log.d("출석 확인", "출석 성공")
                            _snackbarEvent.emit(AttendSnackBarEvent.Attend_success)
                            _qrEnabled.value = false
                        }
                }
                delay(10000L) // 다음 반복까지 10초 대기
            }
        }
    }

    fun formatTime(timeString: String): String {
        val inputFormat = SimpleDateFormat("a hh:mm", Locale.KOREAN)
        val outputFormat = SimpleDateFormat("a h:mm", Locale.KOREAN)

        return try {
            val date = inputFormat.parse(timeString)
            outputFormat.format(date)
        } catch (e: Exception) {
            Log.d("변환 실패", "time")
            timeString
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    val timeUntilEvent = flow {
        while (true) {
            emit(LocalDateTime.now())
            delay(60000)
        }
    }.flatMapLatest { currentTime ->
        upcomingAttend.map { attend ->
            calculateTimeTerm(attend.date, currentTime)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = ""
    )

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateTimeTerm(date: String, currentTime: LocalDateTime): String {
        if (date.isEmpty()) return ""

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        val eventDate = LocalDateTime.parse(date, formatter)
        val minutesDiff = ChronoUnit.MINUTES.between(currentTime, eventDate)

        return when {
            minutesDiff > 1440 -> "D-${minutesDiff / 1440}" // 하루 이상
            minutesDiff in 1..1439 -> {
                val hours = minutesDiff / 60
                val minutes = minutesDiff % 60
                String.format("%02d:%02d",  hours, minutes)
            } // 하루 이하
            minutesDiff in -30..120 -> "Soon" // 이벤트 시작 2시간 이내
            minutesDiff <= -30 -> "Ended" // 이벤트 시작 후 30분 지남
            else -> "No Event"
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

    enum class AttendSnackBarEvent {
        Attend_success, Attend_fail, None
    }
}