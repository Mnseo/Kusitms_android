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

public val KusitmsIcons.BottomNavHome: ImageVector
    get() {
        if (_bottomnavhome != null) {
            return _bottomnavhome!!
        }
        _bottomnavhome = Builder(name = "Bottomnavhome", defaultWidth = 25.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFF4F6F8)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(21.5f, 10.1503f)
                verticalLineTo(17.9668f)
                curveTo(21.5f, 20.1943f, 19.7091f, 22.0f, 17.5f, 22.0f)
                horizontalLineTo(7.5f)
                curveTo(5.2909f, 22.0f, 3.5f, 20.1943f, 3.5f, 17.9668f)
                verticalLineTo(10.1503f)
                curveTo(3.5f, 8.9394f, 4.0396f, 7.7925f, 4.9699f, 7.0265f)
                lineTo(9.9699f, 2.9093f)
                curveTo(11.4423f, 1.6969f, 13.5577f, 1.6969f, 15.0301f, 2.9093f)
                lineTo(20.0301f, 7.0265f)
                curveTo(20.9604f, 7.7925f, 21.5f, 8.9394f, 21.5f, 10.1503f)
                close()
                moveTo(10.5f, 17.25f)
                curveTo(10.0858f, 17.25f, 9.75f, 17.5858f, 9.75f, 18.0f)
                curveTo(9.75f, 18.4142f, 10.0858f, 18.75f, 10.5f, 18.75f)
                horizontalLineTo(14.5f)
                curveTo(14.9142f, 18.75f, 15.25f, 18.4142f, 15.25f, 18.0f)
                curveTo(15.25f, 17.5858f, 14.9142f, 17.25f, 14.5f, 17.25f)
                horizontalLineTo(10.5f)
                close()
            }
        }
        .build()
        return _bottomnavhome!!
    }

private var _bottomnavhome: ImageVector? = null
