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

public val KusitmsIcons.BottomNavProfile: ImageVector
    get() {
        if (_bottomnavprofile != null) {
            return _bottomnavprofile!!
        }
        _bottomnavprofile = Builder(name = "Bottomnavprofile", defaultWidth = 25.0.dp, defaultHeight
                = 24.0.dp, viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF727783)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(18.5f, 2.0f)
                horizontalLineTo(6.5f)
                curveTo(4.2909f, 2.0f, 2.5f, 3.7909f, 2.5f, 6.0f)
                verticalLineTo(18.0f)
                curveTo(2.5f, 19.8642f, 3.7753f, 21.4306f, 5.5011f, 21.8743f)
                curveTo(5.8204f, 21.9563f, 6.1551f, 22.0f, 6.5f, 22.0f)
                horizontalLineTo(18.5f)
                curveTo(18.8449f, 22.0f, 19.1796f, 21.9563f, 19.4989f, 21.8743f)
                curveTo(21.2247f, 21.4306f, 22.5f, 19.8642f, 22.5f, 18.0f)
                verticalLineTo(6.0f)
                curveTo(22.5f, 3.7909f, 20.7091f, 2.0f, 18.5f, 2.0f)
                close()
                moveTo(12.5f, 13.0f)
                curveTo(14.9617f, 13.0f, 17.0783f, 14.6062f, 18.0115f, 16.9071f)
                curveTo(18.4491f, 17.986f, 17.5067f, 19.0f, 16.3425f, 19.0f)
                horizontalLineTo(8.6575f)
                curveTo(7.4933f, 19.0f, 6.5509f, 17.986f, 6.9885f, 16.9071f)
                curveTo(7.9217f, 14.6062f, 10.0383f, 13.0f, 12.5f, 13.0f)
                close()
                moveTo(12.5f, 5.0f)
                curveTo(14.1569f, 5.0f, 15.5f, 6.3432f, 15.5f, 8.0f)
                curveTo(15.5f, 9.6568f, 14.1569f, 11.0f, 12.5f, 11.0f)
                curveTo(10.8431f, 11.0f, 9.5f, 9.6568f, 9.5f, 8.0f)
                curveTo(9.5f, 6.3432f, 10.8431f, 5.0f, 12.5f, 5.0f)
                close()
            }
        }
        .build()
        return _bottomnavprofile!!
    }

private var _bottomnavprofile: ImageVector? = null
