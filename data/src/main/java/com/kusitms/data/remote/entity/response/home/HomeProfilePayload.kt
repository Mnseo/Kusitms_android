package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.HomeProfileModel

data class HomeProfilePayload(
    val name: String,
    val period: String,
    val part: String,
)

fun HomeProfilePayload.toModel() =
    HomeProfileModel(
        name, period, part
    )