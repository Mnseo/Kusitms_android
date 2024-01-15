package com.kusitms.presentation.model.profile

data class PartList(
    val id: Int,
    val name: String,
)

val categories = listOf(
    PartList(1, "기획팀"),
    PartList(2, "디자인팀"),
    PartList(3, "개발팀"),
)