package com.kusitms.domain.model.home

import com.kusitms.domain.model.profile.InterestModel
import com.kusitms.domain.model.profile.LinkModel

data class TeamProfileModel(
    val memberId: Int = 0,
    val name: String = "",
    val part: String = "",
    val period: String = "",
    val profileImage: String = "",
    val description: String = "",
    val major: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val interests: List<InterestModel> = emptyList(),
    val links: List<LinkModel> = emptyList()
)