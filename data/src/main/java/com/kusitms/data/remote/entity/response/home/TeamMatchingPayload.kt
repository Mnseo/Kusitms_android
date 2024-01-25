package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.TeamMatchingModel

data class TeamMatchingPayload(
    val curriculumName: String,
    val teamId: Int,
)

fun TeamMatchingPayload.toModel() =
    TeamMatchingModel(
        curriculumName, teamId
    )