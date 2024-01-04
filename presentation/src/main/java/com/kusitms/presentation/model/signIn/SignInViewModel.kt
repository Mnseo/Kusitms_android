package com.kusitms.presentation.model.signIn

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.Interest
import com.kusitms.domain.model.Link
import com.kusitms.domain.model.SignInProfile
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.usecase.signin.AuthMemberProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authMemberProfileUseCase: AuthMemberProfileUseCase
): ViewModel() {
    private val _major = MutableStateFlow("")
    val major: StateFlow<String> = _major

    private val _isAllFieldsValid = MutableStateFlow(false)
    val isAllFieldsValid: StateFlow<Boolean> = _isAllFieldsValid

    private val _selectedPart = MutableStateFlow<String?>(null)
    val selectedPart: StateFlow<String?> = _selectedPart

    private val _favoriteCategory = MutableStateFlow<List<String>?>(null)
    val favoriteCategory: StateFlow<List<String>?> = _favoriteCategory

    private val _interests = MutableStateFlow<List<InterestItem>>(emptyList())
    val interests: StateFlow<List<InterestItem>> = _interests.asStateFlow()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _phoneNum = MutableStateFlow("")
    val phoneNum: StateFlow<String> = _phoneNum

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _selectedImage = MutableStateFlow<Uri?>(null)
    val selectedImage: StateFlow<Uri?> = _selectedImage.asStateFlow()

    private val _link = MutableStateFlow<String>("")
    val link: StateFlow<String> = _link

    private val _linkType = MutableStateFlow<LinkType?>(null)
    val linkType: StateFlow<LinkType?> = _linkType.asStateFlow()

    private val _linkItems = MutableStateFlow<List<LinkItem>>(listOf(LinkItem(LinkType.LINK, "")))
    val linkItems: StateFlow<List<LinkItem>> = _linkItems.asStateFlow()

    private val _linkCount = MutableStateFlow(1)
    val linkCount: StateFlow<Int> = _linkCount

    private val _introduce = MutableStateFlow("")
    val introduce: StateFlow<String> = _introduce


    fun loadLoginMemberProfile() {
        viewModelScope.launch {
            val result = authMemberProfileUseCase()
            result.onSuccess { profile ->
                Log.d("ViewModel 프로필 확인", profile?.email ?: "프로필이 null임")
                Log.d("가져오기 성공", "성공")
                profile?.let {
                    Log.d("프로필 확인", it.email)
                    _name.value = it.name
                    _email.value = it.email
                    _phoneNum.value = it.phoneNumber
                    validateFields()
                }
            }
            result.onFailure {
                Timber.e(it)
            }
        }
    }

    fun updateMajor(newMajor: String) {
        _major.value = newMajor
        validateFields()
    }

    fun updateSelectedPart(part: String) {
        _selectedPart.value = part
        validateFields()
    }

    fun updateInterests(interestItems: List<InterestItem>) {
        _interests.value = interestItems
        validateFields()
    }

    fun updateSelectedImage(uri: Uri?) {
        _selectedImage.value = uri
    }

    fun updateLinkTypeAt(index: Int, linkType: LinkType) {
        val updatedItems = _linkItems.value.toMutableList()
        if (index in updatedItems.indices) {
            val currentItem = updatedItems[index]
            updatedItems[index] = currentItem.copy(linkType = linkType)
            _linkItems.value = updatedItems
        }
    }

    fun updateLink(links: String) {
        _link.value = links
    }
    fun addLinkItem() {
        val newLinkItem = LinkItem(LinkType.LINK, "") //기본 설정값
        _linkItems.value = _linkItems.value + newLinkItem
    }

    fun updateLinkItem(index: Int, linkType: LinkType, url: String) {
        val updatedItems = _linkItems.value.toMutableList()
        if (index in updatedItems.indices) {
            updatedItems[index] = LinkItem(linkType, url)
            _linkItems.value = updatedItems
        }
    }

    fun removeLinkItem() {
        if (_linkItems.value.isNotEmpty()) {
            _linkItems.value = _linkItems.value.dropLast(1)
        }
    }

    fun updateIntroduce(introduce: String) {
        _introduce.value = introduce
    }

    private fun validateFields() {
        _isAllFieldsValid.value = _major.value.isNotBlank() &&
                _selectedPart.value != null &&
                _interests.value.isNotEmpty()
    }

    fun sendAdditionalProfile() {
        viewModelScope.launch {
            val signInProfile = SignInProfile(
                major = major.value,
                part = selectedPart.value ?: return@launch,
                interests = interests.value.map {
                    Interest(category = it.category, content =  it.content)
                },
                description = introduce.value,
                links = linkItems.value.map {
                    Link(it.linkType.toString(), it.linkUrl)
                }
            )
        }
    }
}