package com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons

public val KusitmsIcons.Selected: ImageVector
    get() {
        if (_selected != null) {
            return _selected!!
        }
        _selected = Builder(name = "Selected", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFD9DCE1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(12.0f, 22.0f)
                curveTo(17.5228f, 22.0f, 22.0f, 17.5228f, 22.0f, 12.0f)
                curveTo(22.0f, 6.4771f, 17.5228f, 2.0f, 12.0f, 2.0f)
                curveTo(6.4771f, 2.0f, 2.0f, 6.4771f, 2.0f, 12.0f)
                curveTo(2.0f, 17.5228f, 6.4771f, 22.0f, 12.0f, 22.0f)
                close()
                moveTo(16.592f, 9.4605f)
                curveTo(16.8463f, 9.1335f, 16.7874f, 8.6623f, 16.4605f, 8.408f)
                curveTo(16.1335f, 8.1537f, 15.6623f, 8.2126f, 15.408f, 8.5396f)
                lineTo(11.401f, 13.6914f)
                curveTo(11.3119f, 13.806f, 11.1443f, 13.8209f, 11.0364f, 13.7238f)
                lineTo(8.5017f, 11.4426f)
                curveTo(8.1938f, 11.1655f, 7.7196f, 11.1904f, 7.4425f, 11.4983f)
                curveTo(7.1654f, 11.8062f, 7.1904f, 12.2804f, 7.4983f, 12.5575f)
                lineTo(10.033f, 14.8387f)
                curveTo(10.7881f, 15.5183f, 11.9613f, 15.4143f, 12.585f, 14.6123f)
                lineTo(16.592f, 9.4605f)
                close()
            }
        }
        .build()
        return _selected!!
    }

private var _selected: ImageVector? = null
