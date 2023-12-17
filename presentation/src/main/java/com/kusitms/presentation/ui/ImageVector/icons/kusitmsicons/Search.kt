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

public val KusitmsIcons.Search: ImageVector
    get() {
        if (_search != null) {
            return _search!!
        }
        _search = Builder(name = "Search", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF727783)),
                    strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(17.2f, 17.2f)
                lineTo(20.0f, 20.0f)
                moveTo(19.2f, 11.6f)
                curveTo(19.2f, 7.4026f, 15.7974f, 4.0f, 11.6f, 4.0f)
                curveTo(7.4026f, 4.0f, 4.0f, 7.4026f, 4.0f, 11.6f)
                curveTo(4.0f, 15.7974f, 7.4026f, 19.2f, 11.6f, 19.2f)
                curveTo(15.7974f, 19.2f, 19.2f, 15.7974f, 19.2f, 11.6f)
                close()
            }
        }
        .build()
        return _search!!
    }

private var _search: ImageVector? = null
