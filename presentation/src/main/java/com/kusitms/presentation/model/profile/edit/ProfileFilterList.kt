package com.kusitms.presentation.model.profile.edit

data class ProfileFilterList(
    val id: Int,
    val name: String,
)

val categories = listOf(
    ProfileFilterList(1, name = "기본 프로필"),
    ProfileFilterList(2, name = "추가 프로필"),
)
