package com.kusitms.domain.model.home

import com.kusitms.domain.model.profile.InterestModel
import com.kusitms.domain.model.profile.LinkModel

data class MemberInfoDetailModel(
    val major: String = "",
    var part: String = "",
    val interests: List<InterestModel> = emptyList(),
    val description: String = "",
    val profileImage: String = "",
    val links: List<LinkModel> = emptyList(),
)
