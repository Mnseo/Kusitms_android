package com.kusitms.domain.usecase.signin

import com.kusitms.domain.model.SignInProfile
import com.kusitms.domain.repository.SignInRepository
import okhttp3.MultipartBody
import java.io.File
import javax.inject.Inject

class postAdditionalProfileUseCase @Inject constructor(
    private val signInRepository: SignInRepository
) {
    suspend operator fun invoke(
        dto: SignInProfile,
        file: MultipartBody.Part
    ): Result<Unit> {
        return signInRepository.postAdditionalProfile(dto, file)
    }
}