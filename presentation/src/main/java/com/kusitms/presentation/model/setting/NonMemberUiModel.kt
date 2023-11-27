package com.kusitms.presentation.model.setting

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.UriHandler
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kusitms.presentation.navigation.NavRoutes

data class NonMemberUiModel(
    val title: String,
    val url: String = "",
    val onClick: () -> Unit = {}
)

fun getNonMemberSetting(navController: NavHostController): List<NonMemberUiModel> {
    return listOf(
        NonMemberUiModel(title = "개인정보 처리 방침", url = "https://www.naver.com"),
        NonMemberUiModel(title = "서비스 이용약관", url = "https://www.naver.com"),
        NonMemberUiModel(title = "로그인", onClick = { backToLogin(navController) })
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