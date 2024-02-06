package com.kusitms.presentation.model.home.attend

import com.kusitms.domain.model.home.AttendCurrentModel

data class AttendUiState(
    val curriculum:String,
    val date: String,
    val time: String,
    val status: String,
    val attendList: List<AttendCurrentModel> = emptyList()
)


val curriDummy = listOf(
    AttendUiState("전체 OT", "9월 2일", "오후 1:59", "PRESENT"),
    AttendUiState("전체 OT", "9월 9일","출석 실패", "ABSENT"),
    AttendUiState("전문가 초청 강연", "9월 16일","오후 2:13", "LATE"),

)
