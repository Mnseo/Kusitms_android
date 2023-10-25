package com.kusitms.domain.entity.member

import com.kusitms.domain.model.LikeCategory

data class Member(
    val name: String = "",
    val major: String = "",
    val part: String = "",
    val category: LikeCategory? = null,
    val email: String ="",
    val phoneNumber: String = "",
)