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

public val KusitmsIcons.BottomNavNotice: ImageVector
    get() {
        if (_bottomnavnotice != null) {
            return _bottomnavnotice!!
        }
        _bottomnavnotice = Builder(name = "Bottomnavnotice", defaultWidth = 19.0.dp, defaultHeight =
                21.0.dp, viewportWidth = 19.0f, viewportHeight = 21.0f).apply {
            path(fill = SolidColor(Color(0xFF727783)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(14.2495f, 1.0f)
                curveTo(14.2495f, 0.5858f, 13.9137f, 0.25f, 13.4995f, 0.25f)
                curveTo(13.0853f, 0.25f, 12.7495f, 0.5858f, 12.7495f, 1.0f)
                verticalLineTo(2.5f)
                horizontalLineTo(6.2495f)
                verticalLineTo(1.0f)
                curveTo(6.2495f, 0.5858f, 5.9137f, 0.25f, 5.4995f, 0.25f)
                curveTo(5.0853f, 0.25f, 4.7495f, 0.5858f, 4.7495f, 1.0f)
                verticalLineTo(2.5f)
                horizontalLineTo(4.5f)
                curveTo(2.2909f, 2.5f, 0.5f, 4.2909f, 0.5f, 6.5f)
                verticalLineTo(17.0f)
                curveTo(0.5f, 19.2091f, 2.2909f, 21.0f, 4.5f, 21.0f)
                horizontalLineTo(14.5f)
                curveTo(16.7091f, 21.0f, 18.5f, 19.2091f, 18.5f, 17.0f)
                verticalLineTo(6.5f)
                curveTo(18.5f, 4.2909f, 16.7091f, 2.5f, 14.5f, 2.5f)
                horizontalLineTo(14.2495f)
                verticalLineTo(1.0f)
                close()
                moveTo(5.5f, 7.25f)
                curveTo(5.0858f, 7.25f, 4.75f, 7.5858f, 4.75f, 8.0f)
                curveTo(4.75f, 8.4142f, 5.0858f, 8.75f, 5.5f, 8.75f)
                horizontalLineTo(9.5f)
                curveTo(9.9142f, 8.75f, 10.25f, 8.4142f, 10.25f, 8.0f)
                curveTo(10.25f, 7.5858f, 9.9142f, 7.25f, 9.5f, 7.25f)
                horizontalLineTo(5.5f)
                close()
                moveTo(4.75f, 12.0f)
                curveTo(4.75f, 11.5858f, 5.0858f, 11.25f, 5.5f, 11.25f)
                horizontalLineTo(13.5f)
                curveTo(13.9142f, 11.25f, 14.25f, 11.5858f, 14.25f, 12.0f)
                curveTo(14.25f, 12.4142f, 13.9142f, 12.75f, 13.5f, 12.75f)
                horizontalLineTo(5.5f)
                curveTo(5.0858f, 12.75f, 4.75f, 12.4142f, 4.75f, 12.0f)
                close()
                moveTo(5.5f, 15.25f)
                curveTo(5.0858f, 15.25f, 4.75f, 15.5858f, 4.75f, 16.0f)
                curveTo(4.75f, 16.4142f, 5.0858f, 16.75f, 5.5f, 16.75f)
                horizontalLineTo(13.5f)
                curveTo(13.9142f, 16.75f, 14.25f, 16.4142f, 14.25f, 16.0f)
                curveTo(14.25f, 15.5858f, 13.9142f, 15.25f, 13.5f, 15.25f)
                horizontalLineTo(5.5f)
                close()
            }
        }
        .build()
        return _bottomnavnotice!!
    }

private var _bottomnavnotice: ImageVector? = null
