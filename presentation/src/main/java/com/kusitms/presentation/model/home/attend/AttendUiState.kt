package com.kusitms.presentation.model.home.attend

data class AttendUiState(
    val curriculum:String,
    val date: String,
    val time: String,
    val status: String
)


val curriDummy = listOf(
    AttendUiState("전체 OT", "9월 2일", "오후 1:59", "PRESENT")
)
