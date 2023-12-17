package com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons

public val KusitmsIcons.Unchecked: ImageVector
    get() {
        if (_unchecked != null) {
            return _unchecked!!
        }
        _unchecked = Builder(name = "Unchecked", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF727783)),
                    strokeLineWidth = 1.25f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.6665f, 10.0f)
                lineTo(8.7787f, 11.901f)
                curveTo(9.1383f, 12.2246f, 9.697f, 12.1751f, 9.994f, 11.7932f)
                lineTo(13.3332f, 7.5f)
                moveTo(9.9998f, 18.3333f)
                curveTo(14.6022f, 18.3333f, 18.3332f, 14.6024f, 18.3332f, 10.0f)
                curveTo(18.3332f, 5.3976f, 14.6022f, 1.6667f, 9.9998f, 1.6667f)
                curveTo(5.3975f, 1.6667f, 1.6665f, 5.3976f, 1.6665f, 10.0f)
                curveTo(1.6665f, 14.6024f, 5.3975f, 18.3333f, 9.9998f, 18.3333f)
                close()
            }
        }
        .build()
        return _unchecked!!
    }

private var _unchecked: ImageVector? = null
