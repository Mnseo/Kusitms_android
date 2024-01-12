package com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons

public val KusitmsIcons.BottomNavAttendance: ImageVector
    get() {
        if (_bottomnavattendance != null) {
            return _bottomnavattendance!!
        }
        _bottomnavattendance = Builder(name = "Bottomnavattendance", defaultWidth = 25.0.dp,
                defaultHeight = 24.0.dp, viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF727783)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(6.5f, 2.0f)
                curveTo(4.2909f, 2.0f, 2.5f, 3.7909f, 2.5f, 6.0f)
                verticalLineTo(18.0f)
                curveTo(2.5f, 20.2091f, 4.2909f, 22.0f, 6.5f, 22.0f)
                horizontalLineTo(18.5f)
                curveTo(20.7091f, 22.0f, 22.5f, 20.2091f, 22.5f, 18.0f)
                verticalLineTo(6.0f)
                curveTo(22.5f, 3.7909f, 20.7091f, 2.0f, 18.5f, 2.0f)
                horizontalLineTo(6.5f)
                close()
                moveTo(13.25f, 7.0f)
                curveTo(13.25f, 6.5858f, 12.9142f, 6.25f, 12.5f, 6.25f)
                curveTo(12.0858f, 6.25f, 11.75f, 6.5858f, 11.75f, 7.0f)
                verticalLineTo(12.0f)
                curveTo(11.75f, 12.3228f, 11.9566f, 12.6094f, 12.2628f, 12.7115f)
                lineTo(15.2628f, 13.7115f)
                curveTo(15.6558f, 13.8425f, 16.0805f, 13.6301f, 16.2115f, 13.2372f)
                curveTo(16.3425f, 12.8442f, 16.1301f, 12.4195f, 15.7372f, 12.2885f)
                lineTo(13.25f, 11.4594f)
                verticalLineTo(7.0f)
                close()
            }
        }
        .build()
        return _bottomnavattendance!!
    }

private var _bottomnavattendance: ImageVector? = null
