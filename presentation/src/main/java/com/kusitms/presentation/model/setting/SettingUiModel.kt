package com.kusitms.presentation.model.setting

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.font.FontVariation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.kusitms.domain.usecase.signin.MemberLogOutUseCase
import com.kusitms.domain.usecase.signin.MemberSignOutUseCase
import com.kusitms.presentation.R
import com.kusitms.presentation.model.login.LoginStatus
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.navigation.NavRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor(
    private val memberLogOutUseCase: MemberLogOutUseCase,
    private val memberSignOutUseCase: MemberSignOutUseCase,
): ViewModel() {
    private val _alarmState = MutableStateFlow(false)
    val alarmState: StateFlow<Boolean> = _alarmState.asStateFlow()

    private val _settingStatus = MutableStateFlow(SettingStatus.DEFAULT)
    val settingStatus: StateFlow<SettingStatus> = _settingStatus


    fun onToggleChange(newToggleState: Boolean) {
        _alarmState.value = newToggleState
    }

    fun updateSettingStatus(settingStatus: SettingStatus) {
        _settingStatus.value = settingStatus
    }

    fun logOut() {
        viewModelScope.launch {
            memberLogOutUseCase()
                .onSuccess {
                    updateSettingStatus(SettingStatus.LOGOUT_SUCCESS)
                }
                .onFailure {
                    updateSettingStatus(SettingStatus.ERROR)
                }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            memberSignOutUseCase()
                .onSuccess {
                    updateSettingStatus(SettingStatus.SIGNOUT_SUCCESS)
                }
                .onFailure {
                    updateSettingStatus(SettingStatus.ERROR)
                }
        }
    }


    enum class SettingStatus {
            LOGOUT, LOGOUT_SUCCESS, SIGNOUT_INIT,SIGNOUT, SIGNOUT_SUCCESS, DEFAULT, ERROR;

        @StringRes
        fun getTitleResId(): Int {
            return when (this) {
                LOGOUT -> R.string.logout_dialog_title
                SIGNOUT -> R.string.signout_dialog_title
                else -> R.string.signout_blank_title
            }
        }
        @StringRes
        fun getContentResId(): Int {
            return when (this) {
                LOGOUT -> R.string.logout_dialog_content
                SIGNOUT -> R.string.signout_dialog_content
                else -> R.string.signout_blank_title
            }
        }
    }

}
data class SettingUiModel(
    val title: String,
    val url: String = "",
    val onClick: () -> Unit = {}
)

fun getNonMemberSetting(navController: NavHostController): List<SettingUiModel> {
    return listOf(
        SettingUiModel(title = "개인정보 처리 방침", url = "https://sheer-billboard-d63.notion.site/KUSITMS-9e6619383bcd4ce68b6ba4b2b6ef0d40?pvs=4"),
        SettingUiModel(title = "서비스 이용약관", url = "https://sheer-billboard-d63.notion.site/24a4639559d4433cb89c8f1abb889726?pvs=4"),
        SettingUiModel(title = "로그인", onClick = { backToLogin(navController) })
    )
}

fun getMemberSetting(viewModel: SettingViewModel, navController: NavHostController): List<SettingUiModel> {
    return listOf(
        SettingUiModel(title = "개인정보 처리 방침", url = "https://sheer-billboard-d63.notion.site/KUSITMS-9e6619383bcd4ce68b6ba4b2b6ef0d40?pvs=4"),
        SettingUiModel(title = "서비스 이용약관", url = "https://sheer-billboard-d63.notion.site/24a4639559d4433cb89c8f1abb889726?pvs=4"),
        SettingUiModel(title = "비밀번호 변경", onClick = { goToSetPw(navController) }),
        SettingUiModel(title = "로그아웃", onClick = { viewModel.updateSettingStatus(SettingViewModel.SettingStatus.LOGOUT) }),
        SettingUiModel(title = "회원탈퇴", onClick = { viewModel.updateSettingStatus(SettingViewModel.SettingStatus.SIGNOUT_INIT) })
    )
}

fun openUriSetting(url: String, uriHandler: UriHandler) {
    if(url.isNotEmpty()) {
        uriHandler.openUri(url)
    }
}


fun backToLogin(navController: NavHostController) {
    navController.navigate(NavRoutes.LogInScreen.route)
}

fun goToSetPw(navController: NavHostController) {
    navController.navigate(NavRoutes.FindPwMemberCurrent.route)
}
