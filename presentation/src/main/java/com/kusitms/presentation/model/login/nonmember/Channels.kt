package com.kusitms.presentation.model.login.nonmember

import androidx.compose.ui.res.stringResource
import com.kusitms.presentation.R

object Channels {
    val channels = listOf(
        Channel(R.drawable.ic_nonmember_insta, R.string.nonMember_banner1, "https://www.instagram.com/kusitms_official/"),
        Channel(R.drawable.ic_nonmember_youtube, R.string.nonMember_banner2, "https://www.youtube.com/@KUSITMS"),
        Channel(R.drawable.ic_nonmember_chat, R.string.nonMember_banner3, "https://cafe.naver.com/kusitms")
    )
}