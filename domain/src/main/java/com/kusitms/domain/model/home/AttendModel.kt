package com.kusitms.domain.model.home

data class AttendModel(
    val attendId: Int,
    val curriculum: String,
    val date: String,
    val time: String,
    val status: String,
)