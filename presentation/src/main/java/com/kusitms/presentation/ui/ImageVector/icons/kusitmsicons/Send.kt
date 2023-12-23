package com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons

public val KusitmsIcons.Send: ImageVector
    get() {
        if (_send != null) {
            return _send!!
        }
        _send = Builder(name = "Send", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF727783)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(14.22f, 21.6298f)
                curveTo(13.04f, 21.6298f, 11.37f, 20.7998f, 10.05f, 16.8298f)
                lineTo(9.33f, 14.6698f)
                lineTo(7.17f, 13.9498f)
                curveTo(3.21f, 12.6298f, 2.38f, 10.9598f, 2.38f, 9.7798f)
                curveTo(2.38f, 8.6098f, 3.21f, 6.9298f, 7.17f, 5.5998f)
                lineTo(15.66f, 2.7698f)
                curveTo(17.78f, 2.0598f, 19.55f, 2.2698f, 20.64f, 3.3498f)
                curveTo(21.73f, 4.4298f, 21.94f, 6.2098f, 21.23f, 8.3298f)
                lineTo(18.4f, 16.8198f)
                curveTo(17.07f, 20.7998f, 15.4f, 21.6298f, 14.22f, 21.6298f)
                close()
                moveTo(7.64f, 7.0298f)
                curveTo(4.86f, 7.9598f, 3.87f, 9.0598f, 3.87f, 9.7798f)
                curveTo(3.87f, 10.4998f, 4.86f, 11.5998f, 7.64f, 12.5198f)
                lineTo(10.16f, 13.3598f)
                curveTo(10.38f, 13.4298f, 10.56f, 13.6098f, 10.63f, 13.8298f)
                lineTo(11.47f, 16.3498f)
                curveTo(12.39f, 19.1298f, 13.5f, 20.1198f, 14.22f, 20.1198f)
                curveTo(14.94f, 20.1198f, 16.04f, 19.1298f, 16.97f, 16.3498f)
                lineTo(19.8f, 7.8598f)
                curveTo(20.31f, 6.3198f, 20.22f, 5.0598f, 19.57f, 4.4098f)
                curveTo(18.92f, 3.7598f, 17.66f, 3.6798f, 16.13f, 4.1898f)
                lineTo(7.64f, 7.0298f)
                close()
            }
            path(fill = SolidColor(Color(0xFF727783)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.11f, 14.4f)
                curveTo(9.92f, 14.4f, 9.73f, 14.33f, 9.58f, 14.18f)
                curveTo(9.29f, 13.89f, 9.29f, 13.41f, 9.58f, 13.12f)
                lineTo(13.16f, 9.53f)
                curveTo(13.45f, 9.24f, 13.93f, 9.24f, 14.22f, 9.53f)
                curveTo(14.51f, 9.82f, 14.51f, 10.3f, 14.22f, 10.59f)
                lineTo(10.64f, 14.18f)
                curveTo(10.5f, 14.33f, 10.3f, 14.4f, 10.11f, 14.4f)
                close()
            }
        }
        .build()
        return _send!!
    }

private var _send: ImageVector? = null
