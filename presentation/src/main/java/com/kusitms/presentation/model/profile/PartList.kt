package com.kusitms.presentation.model.profile

data class PartList(
    val id: Int,
    val name: String,
)

val categories = listOf(
    PartList(1, "기획팀"),
    PartList(2, "개발팀"),
    PartList(3, "디자인팀"),
)