package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.MemberInfoDetailModel
import com.kusitms.domain.model.profile.InterestModel
import com.kusitms.domain.model.profile.LinkModel

data class MemberInfoDetailPayload(
    val major: String?,
    val part: String?,
    val interests: List<InterestModel>?,
    val description: String?,
    val profileImage: String?,
    val links: List<LinkModel>?,
)

fun MemberInfoDetailPayload.toModel() =
    MemberInfoDetailModel(
        major = major,
        part = part,
        interests = interests,
        description = description,
        profileImage = profileImage,
        links = links
    )