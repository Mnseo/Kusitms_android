package com.kusitms.data.repository

import android.util.Log
import com.google.gson.Gson
import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.request.toBody
import com.kusitms.data.remote.entity.response.toModel
import com.kusitms.domain.model.SignInProfile
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.signin.SignInRequestCheckModel
import com.kusitms.domain.repository.SignInRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
): SignInRepository {
    override suspend fun getLoginMemberProfile(): Result<LoginMemberProfile> {
        return try {
            val response = kusitmsApi.loginMemberProfile()
            if (response.payload == null) {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
            } else {
                val profile = LoginMemberProfile(
                    name = response.payload.name,
                    email = response.payload.email,
                    period = response.payload.period,
                    phoneNumber = response.payload.phoneNumber,
                    memberDetailExist = response.payload.memberDetailExist
                )
                AuthDataStore().loginMemberProfile = profile
                Result.success(profile)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signInRequestCheck(
        email: String,
        password: String
    ): Result<SignInRequestCheckModel> {
        return try {
            val response = kusitmsApi.signInRequestCheck(email, password)
            if(response.payload == null) {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
            } else {
                Result.success(response.payload.toModel())
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signInRequest(
        email: String,
        password: String
    ): Result<Unit> {
        return try {
            val response = kusitmsApi.signInRequest(email, password)
            if(response.result == null) {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
            } else {
                Result.success(Unit)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun postAdditionalProfile(profile: SignInProfile, filePart: MultipartBody.Part): Result<Unit> {
        return try {
            val gson = Gson()
            val profileJson = gson.toJson(profile)
            val profileRequestBody = profileJson.toRequestBody("application/json".toMediaTypeOrNull())

            Log.d("profileRequestBody", profileJson.toString())
            val response = kusitmsApi.sendAdditionalProfile(
                profileRequestBody,
                filePart
            )
            Log.d("응답", response.toString())

            if (response.result.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}