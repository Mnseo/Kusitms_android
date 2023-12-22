package com.kusitms.domain.usecase.findpw

import com.kusitms.domain.model.findpw.FindPwCheckEmailModel
import com.kusitms.domain.repository.FindPwRepository
import javax.inject.Inject

class FindPwEmailVerifyUseCase @Inject constructor(
    private val findPwRepository: FindPwRepository
) {
    suspend operator fun invoke(
        email:String
    ): Result<FindPwCheckEmailModel> {
        return findPwRepository.FindPwEmailCheck(email)
    }

}