package com.kusitms.presentation.model.signIn

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.Interest
import com.kusitms.domain.model.Link
import com.kusitms.domain.model.SignInProfile
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.usecase.signin.AuthMemberProfileUseCase
import com.kusitms.domain.usecase.signin.postAdditionalProfileUseCase
import com.kusitms.presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import kotlin.math.sign

enum class SignInStatus { SUCCESS, ERROR,DEFAULT }

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authMemberProfileUseCase: AuthMemberProfileUseCase,
    private val postAdditionalProfileUseCase: postAdditionalProfileUseCase,
    @ApplicationContext private val context: Context
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

    private val _linkItems = MutableStateFlow<List<LinkItem>>(listOf(LinkItem(LinkType.LINK, "")))
    val linkItems: StateFlow<List<LinkItem>> = _linkItems.asStateFlow()

    private val _introduce = MutableStateFlow("")
    val introduce: StateFlow<String> = _introduce

    private val _signInStatus = MutableStateFlow(SignInStatus.DEFAULT)
    val signInStatus : StateFlow<SignInStatus> = _signInStatus


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

    fun updateSignInStatus(signInStatus: SignInStatus) {
        _signInStatus.value = signInStatus
    }

    private fun validateFields() {
        _isAllFieldsValid.value = _major.value.isNotBlank() &&
                _selectedPart.value != null &&
                _interests.value.isNotEmpty()
    }

    private fun uriToFile(context: Context, fileUri: Uri): MultipartBody.Part {
        val inputStream = context.contentResolver.openInputStream(fileUri)
        val tempFile = File.createTempFile("upload", "jpg", context.cacheDir).apply {
            deleteOnExit()
        }
        FileOutputStream(tempFile).use { fileOutputStream ->
            inputStream?.copyTo(fileOutputStream)
        }

        val requestFile = tempFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("image", tempFile.name, requestFile)
    }

    private fun getDefaultImagePart(context: Context): MultipartBody.Part {
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_profile_default)
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val requestBody = byteArrayOutputStream.toByteArray().toRequestBody("image/png".toMediaTypeOrNull())

        return MultipartBody.Part.createFormData("image", "default.png", requestBody)
    }

    fun sendAdditionalProfile() {
        val imageUri = selectedImage.value
        val imagePart = imageUri?.let { uriToFile(context, it) }
            ?: getDefaultImagePart(context)
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
            Log.d("signInProfile", signInProfile.toString())


            Log.d("성공", "api_profile 성공")
            postAdditionalProfileUseCase(signInProfile, imagePart)
                .onSuccess {
                    Log.d("signIn_profile", "성공")
                    updateSignInStatus(SignInStatus.SUCCESS)
                }
                .onFailure {
                    Log.d("signIn_profile", "실패")
                    Timber.e(it)
                    updateSignInStatus(SignInStatus.ERROR)
                }
        }
    }
}