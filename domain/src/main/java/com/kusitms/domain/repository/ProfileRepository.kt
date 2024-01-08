package com.kusitms.domain.repository

import com.kusitms.domain.model.profile.ProfileModel

interface ProfileRepository {
    suspend fun getProfileList(): Result<List<ProfileModel>>
}