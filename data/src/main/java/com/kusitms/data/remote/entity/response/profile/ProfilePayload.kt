package com.kusitms.data.remote.entity.response.profile

import com.kusitms.domain.model.profile.ProfileModel

data class ProfilePayload(
    val memberId: Int = 0,
    val name: String = "",
    val part: String = "",
    val profileImage: String = "",
    val description: String = ""
)

fun ProfilePayload.toModel() =
    ProfileModel(
        memberId = memberId ?: 0,
        name = name ?: "",
        part = part ?: "",
        profileImage = profileImage ?: "",
        description = description ?: "",
    )