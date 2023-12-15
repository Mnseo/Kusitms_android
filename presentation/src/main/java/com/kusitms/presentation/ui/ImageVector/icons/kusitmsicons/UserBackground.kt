package com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons

public val KusitmsIcons.UserBackground: ImageVector
    get() {
        if (_userBackground != null) {
            return _userBackground!!
        }
        _userBackground = Builder(name = "UserBackground", defaultWidth = 16.0.dp, defaultHeight =
                16.0.dp, viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFF727783)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.0f, 0.0f)
                lineTo(12.0f, 0.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, true, 16.0f, 4.0f)
                lineTo(16.0f, 12.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, true, 12.0f, 16.0f)
                lineTo(4.0f, 16.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, true, 0.0f, 12.0f)
                lineTo(0.0f, 4.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, true, 4.0f, 0.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF28303F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(8.0f, 7.5f)
                curveTo(9.1046f, 7.5f, 10.0f, 6.6046f, 10.0f, 5.5f)
                curveTo(10.0f, 4.3954f, 9.1046f, 3.5f, 8.0f, 3.5f)
                curveTo(6.8954f, 3.5f, 6.0f, 4.3954f, 6.0f, 5.5f)
                curveTo(6.0f, 6.6046f, 6.8954f, 7.5f, 8.0f, 7.5f)
                close()
                moveTo(8.0f, 12.5f)
                curveTo(9.933f, 12.5f, 11.5f, 11.6046f, 11.5f, 10.5f)
                curveTo(11.5f, 9.3954f, 9.933f, 8.5f, 8.0f, 8.5f)
                curveTo(6.067f, 8.5f, 4.5f, 9.3954f, 4.5f, 10.5f)
                curveTo(4.5f, 11.6046f, 6.067f, 12.5f, 8.0f, 12.5f)
                close()
            }
        }
        .build()
        return _userBackground!!
    }

private var _userBackground: ImageVector? = null
