package com.kusitms.domain.model.home

data class AttendCurrentModel(
    val attendId: Int,
    val curriculum: String,
    val date: String,
    val time: String,
    val status: String,
)

data class AttendModel(
    val penalty: Int,
    val present: Int,
    val absent: Int,
    val late: Int,
    val passYn: String
)

data class AttendInfoModel(
    val curriculumId: Int,
    val curriculumName: String,
    val isAttended: Boolean,
    val date: String,
)