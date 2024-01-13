package com.kusitms.domain.usecase.profile

import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProfileDetailUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {
    operator fun invoke(memberId: Int): Flow<ProfileModel> = flow {
        profileRepository.getProfileDetail(
            memberId
        ).onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}