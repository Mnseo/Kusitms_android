package com.kusitms.presentation.model.setting

import androidx.compose.ui.platform.UriHandler
import androidx.navigation.NavHostController
import com.kusitms.presentation.navigation.NavRoutes

data class SettingUiModel(
    val title: String,
    val url: String = "",
    val onClick: () -> Unit = {}
)

fun getNonMemberSetting(navController: NavHostController): List<SettingUiModel> {
    return listOf(
        SettingUiModel(title = "개인정보 처리 방침", url = "https://www.naver.com"),
        SettingUiModel(title = "서비스 이용약관", url = "https://www.naver.com"),
        SettingUiModel(title = "로그인", onClick = { backToLogin(navController) })
    )
}

fun getMemberSetting(navController: NavHostController): List<SettingUiModel> {
    return listOf(
        SettingUiModel(title = "푸시알림", onClick = { backToLogin(navController) }),
        SettingUiModel(title = "개인정보 처리 방침", url = "https://www.naver.com"),
        SettingUiModel(title = "서비스 이용약관", url = "https://www.naver.com"),
        SettingUiModel(title = "비밀번호 변경", onClick = { backToLogin(navController) }),
        SettingUiModel(title = "로그아웃", onClick = { backToLogin(navController) }),
        SettingUiModel(title = "회원탈퇴", onClick = { backToLogin(navController) })
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