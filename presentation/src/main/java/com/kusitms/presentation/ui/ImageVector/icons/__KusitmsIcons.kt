package com.kusitms.presentation.ui.ImageVector.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.BottomNavAttendance
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.BottomNavHome
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.BottomNavNotice
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.BottomNavProfile
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Chat
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Checked
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Close
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Download
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Flag
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.MoreVertical
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Notice
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.NoticeDark
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Search
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Selected
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Send
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Setting
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Unchecked
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.User
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.UserBackground
import kotlin.collections.List as ____KtList

public object KusitmsIcons

private var __Icons: ____KtList<ImageVector>? = null

public val KusitmsIcons.Icons: ____KtList<ImageVector>
  get() {
    if (__Icons != null) {
      return __Icons!!
    }
    __Icons= listOf(ArrowDown, Chat, Checked, Close, Download, Flag, MoreVertical,
        Notice, NoticeDark, Search, Send, Setting, Unchecked, User, UserBackground,BottomNavAttendance, BottomNavHome, BottomNavNotice, BottomNavProfile,Selected)
    return __Icons!!
  }
