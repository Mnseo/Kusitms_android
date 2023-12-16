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

public val KusitmsIcons.Notice: ImageVector
    get() {
        if (_notice != null) {
            return _notice!!
        }
        _notice = Builder(name = "Notice", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFBE1931)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(9.809f, 18.0017f)
                curveTo(9.6831f, 19.0094f, 8.7638f, 19.3703f, 7.7561f, 19.3703f)
                curveTo(6.7484f, 19.3703f, 6.0335f, 18.5532f, 6.1594f, 17.5455f)
                lineTo(6.6156f, 13.4397f)
                curveTo(6.7415f, 12.4319f, 7.6607f, 11.6149f, 8.6685f, 11.6149f)
                curveTo(9.6762f, 11.6149f, 11.6192f, 11.6149f, 10.2652f, 13.4397f)
                curveTo(8.9112f, 15.2645f, 9.809f, 18.0017f, 9.809f, 18.0017f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCCD6DD)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(20.2635f, 10.7025f)
                curveTo(20.2635f, 13.8512f, 19.5591f, 16.405f, 18.6896f, 16.405f)
                curveTo(17.8206f, 16.405f, 9.3603f, 13.8512f, 9.3603f, 10.7025f)
                curveTo(9.3603f, 7.5533f, 17.8206f, 5.0f, 18.6896f, 5.0f)
                curveTo(19.5591f, 5.0f, 20.2635f, 7.5533f, 20.2635f, 10.7025f)
                close()
            }
            path(fill = SolidColor(Color(0xFF66757F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.6896f, 16.405f)
                curveTo(19.5588f, 16.405f, 20.2635f, 13.8519f, 20.2635f, 10.7025f)
                curveTo(20.2635f, 7.5531f, 19.5588f, 5.0f, 18.6896f, 5.0f)
                curveTo(17.8204f, 5.0f, 17.1157f, 7.5531f, 17.1157f, 10.7025f)
                curveTo(17.1157f, 13.8519f, 17.8204f, 16.405f, 18.6896f, 16.405f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDD2E44)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.0975f, 13.8959f)
                lineTo(5.7108f, 13.4397f)
                curveTo(3.4297f, 13.4397f, 3.4297f, 7.9653f, 5.7108f, 7.9653f)
                lineTo(12.0975f, 7.5091f)
                curveTo(10.7289f, 8.8777f, 10.7289f, 12.5273f, 12.0975f, 13.8959f)
                close()
            }
            path(fill = SolidColor(Color(0xFF99AAB5)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.2107f, 12.6861f)
                curveTo(18.5886f, 12.6861f, 18.895f, 11.798f, 18.895f, 10.7025f)
                curveTo(18.895f, 9.607f, 18.5886f, 8.719f, 18.2107f, 8.719f)
                curveTo(17.8327f, 8.719f, 17.5264f, 9.607f, 17.5264f, 10.7025f)
                curveTo(17.5264f, 11.798f, 17.8327f, 12.6861f, 18.2107f, 12.6861f)
                close()
            }
        }
        .build()
        return _notice!!
    }

private var _notice: ImageVector? = null
