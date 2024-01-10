package com.kusitms.domain.usecase.profile

import com.kusitms.domain.model.profile.ProfileModel
import com.kusitms.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProfileListUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    operator fun invoke(): Flow<List<ProfileModel>> = flow {
        profileRepository.getProfileList()
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}