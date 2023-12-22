package com.kusitms.domain.usecase.findpw

import com.kusitms.domain.repository.FindPwRepository
import javax.inject.Inject

class FindPwEmailVerifyUseCase @Inject constructor(
    private val findPwRepository: FindPwRepository
) {

}