package com.kusitms.domain.model.home

import com.kusitms.domain.model.profile.InterestModel
import com.kusitms.domain.model.profile.LinkModel

data class MemberInfoDetailModel(
    val major: String?,
    val part: String?,
    val interests: List<InterestModel>?,
    val description: String?,
    val profileImage: String? = null,
    val links: List<LinkModel>?
)
