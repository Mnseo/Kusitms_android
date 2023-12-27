package com.kusitms.domain.usecase.findpw

import com.kusitms.domain.model.findpw.FindPwCodeVerifyModel
import com.kusitms.domain.repository.FindPwRepository
import javax.inject.Inject

class FindPwCodeVerifyUseCase @Inject constructor(
    private val findPwRepository: FindPwRepository
) {
    suspend operator fun invoke(
        email:String,
        code:String
    ): Result<FindPwCodeVerifyModel> {
        return findPwRepository.VerifyCode(email, code)
    }
}