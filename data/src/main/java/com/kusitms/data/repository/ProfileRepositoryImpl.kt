package com.kusitms.data.repository

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.repository.ProfileRepository
import java.lang.Exception
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
): ProfileRepository {

//    override suspend fun getProfileList(): Result<List<ProfileModel>> {
//        return try {
//
//        } catch (e: Exception) {
//
//        }
//    }
}