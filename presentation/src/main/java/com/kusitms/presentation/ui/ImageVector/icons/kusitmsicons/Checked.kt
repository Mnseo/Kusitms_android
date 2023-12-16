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

public val KusitmsIcons.Checked: ImageVector
    get() {
        if (_checked != null) {
            return _checked!!
        }
        _checked = Builder(name = "Checked", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(9.9998f, 18.3333f)
                curveTo(14.6022f, 18.3333f, 18.3332f, 14.6024f, 18.3332f, 10.0f)
                curveTo(18.3332f, 5.3976f, 14.6022f, 1.6667f, 9.9998f, 1.6667f)
                curveTo(5.3975f, 1.6667f, 1.6665f, 5.3976f, 1.6665f, 10.0f)
                curveTo(1.6665f, 14.6024f, 5.3975f, 18.3333f, 9.9998f, 18.3333f)
                close()
                moveTo(13.8265f, 7.8837f)
                curveTo(14.0384f, 7.6113f, 13.9894f, 7.2186f, 13.7169f, 7.0067f)
                curveTo(13.4444f, 6.7948f, 13.0517f, 6.8439f, 12.8398f, 7.1163f)
                lineTo(9.5007f, 11.4095f)
                curveTo(9.4264f, 11.505f, 9.2867f, 11.5174f, 9.1968f, 11.4365f)
                lineTo(7.0846f, 9.5355f)
                curveTo(6.828f, 9.3046f, 6.4329f, 9.3254f, 6.202f, 9.5819f)
                curveTo(5.971f, 9.8385f, 5.9918f, 10.2337f, 6.2484f, 10.4646f)
                lineTo(8.3606f, 12.3656f)
                curveTo(8.9899f, 12.9319f, 9.9676f, 12.8452f, 10.4874f, 12.177f)
                lineTo(13.8265f, 7.8837f)
                close()
            }
        }
        .build()
        return _checked!!
    }

private var _checked: ImageVector? = null
