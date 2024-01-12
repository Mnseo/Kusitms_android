package com.kusitms.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.kusitms.presentation.R
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.BottomNavAttendance
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.BottomNavHome
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.BottomNavNotice
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.BottomNavProfile

enum class TopLevelDestination(
    val icon: ImageVector,
    val iconTextId: Int,
    val route : String
) {
    HOME(
        icon = KusitmsIcons.BottomNavHome,
        iconTextId = R.string.bottom_nav_home,
        route = NavRoutes.HomeScreen.route
    ),
    ATTENDANCE(
        icon = KusitmsIcons.BottomNavAttendance,
        iconTextId = R.string.bottom_nav_attendance,
        route = ""
    ),
    NOTICE(
        icon = KusitmsIcons.BottomNavNotice,
        iconTextId = R.string.bottom_nav_notice,
        route = NavRoutes.Notice.route
    ),
    PROFILE(
        icon = KusitmsIcons.BottomNavProfile,
        iconTextId = R.string.bottom_nav_profile,
        route = NavRoutes.Profile.route
    ),
}