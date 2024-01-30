package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.TeamProfileModel
import com.kusitms.domain.model.profile.InterestModel
import com.kusitms.domain.model.profile.LinkModel

data class TeamProfilePayload(
    val memberId: Int? = 0,
    val name: String? = "",
    val part: String? = "",
    val period: String? = "",
    val profileImage: String? = "",
    val description: String? = "",
    val major: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val interests: List<InterestModel> = emptyList(),
    val links: List<LinkModel> = emptyList()
)

fun TeamProfilePayload.toModel() =
    TeamProfileModel(
        memberId = memberId ?: 0,
        name = name ?: "",
        part = part ?: "",
        period = period ?: "",
        profileImage = profileImage ?: "",
        description = description ?: "",
        major = major,
        email = email,
        phoneNumber = phoneNumber,
        interests = interests,
        links = links
    )