package com.kusitms.data.remote.entity.request

import com.kusitms.domain.model.Interest
import com.kusitms.domain.model.Link
import com.kusitms.domain.model.SignInProfile

data class AdditionalProfileBody(
    val major: String,
    val part: String,
    val interests: List<Interest>,
    val description: String,
    val links: List<Link>
)

fun SignInProfile.toBody() =
    AdditionalProfileBody(
        major, part, interests, description, links
    )
