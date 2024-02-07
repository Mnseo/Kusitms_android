package com.kusitms.presentation.model.profile.edit

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.kusitms.presentation.model.signIn.InterestItem
import com.kusitms.presentation.model.signIn.LinkItem
import com.kusitms.presentation.model.signIn.LinkType
import com.kusitms.presentation.model.signIn.SignInStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileEditUiState())
    val uiState: StateFlow<ProfileEditUiState> = _uiState.asStateFlow()

    private val _isAllFieldsValid = MutableStateFlow(false)
    val isAllFieldsValid: StateFlow<Boolean> = _isAllFieldsValid

    private val _expanded = MutableStateFlow(false)
    val expended: StateFlow<Boolean> = _expanded.asStateFlow()

    private val _favoriteCategory = MutableStateFlow<List<String>?>(null)
    val favoriteCategory: StateFlow<List<String>?> = _favoriteCategory

    private val _interests = MutableStateFlow<List<InterestItem>>(emptyList())
    val interests: StateFlow<List<InterestItem>> = _interests.asStateFlow()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _major = MutableStateFlow("")
    val major: StateFlow<String> = _major

    private val _phoneNum = MutableStateFlow("")
    val phoneNum: StateFlow<String> = _phoneNum

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _emailError = MutableStateFlow<String?>(null)
    val emailError: StateFlow<String?> = _emailError

    private val _phoneNumError = MutableStateFlow<String?>(null)
    val phoneNumError: StateFlow<String?> = _phoneNumError


    private val _selectedImage = MutableStateFlow<Uri?>(null)
    val selectedImage: StateFlow<Uri?> = _selectedImage.asStateFlow()

    private val _linkItems = MutableStateFlow<List<LinkItem>>(listOf(LinkItem(LinkType.LINK, "")))
    val linkItems: StateFlow<List<LinkItem>> = _linkItems.asStateFlow()

    private val _introduce = MutableStateFlow("")
    val introduce: StateFlow<String> = _introduce

    private val _signInStatus = MutableStateFlow(SignInStatus.DEFAULT)
    val signInStatus : StateFlow<SignInStatus> = _signInStatus

    private val _selectedPart = MutableStateFlow<String?>(null)
    val selectedPart: StateFlow<String?> = _selectedPart

    fun changeSelectProfileFilter(category: String) {
        _uiState.value = _uiState.value.copy(currentSelectedProfileFilter = category)
        _expanded.value = false
    }

    fun toggleExpanded() {
        _expanded.value = !_expanded.value
    }

    fun updateMajor(newMajor: String) {
        _major.value = newMajor
        validateFields()
    }

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
        if (!isValidEmail(newEmail)) {
            _emailError.value = "유효한 이메일 주소를 입력해주세요"
        } else {
            _emailError.value = null
        }
        validateFields()
    }

    fun updatePhoneNumber(newPhoneNumber: String) {
        _phoneNum.value = newPhoneNumber
        if (!isValidPhoneNumber(newPhoneNumber)) {
            _phoneNumError.value = "유효한 전화번호를 입력해주세요 (010-1234-1234)"
        } else {
            _phoneNumError.value = null
        }
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
                _interests.value.isNotEmpty() &&
                _email.value.isNotBlank() &&
                _phoneNum.value.isNotBlank()
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}\$")
        return email.matches(emailRegex)
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phoneRegex = Regex("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}\$")
        return phoneNumber.matches(phoneRegex)
    }
}