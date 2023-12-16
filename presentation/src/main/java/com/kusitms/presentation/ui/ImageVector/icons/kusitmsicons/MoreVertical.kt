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

public val KusitmsIcons.MoreVertical: ImageVector
    get() {
        if (_moreVertical != null) {
            return _moreVertical!!
        }
        _moreVertical = Builder(name = "MoreVertical", defaultWidth = 3.0.dp, defaultHeight =
                13.0.dp, viewportWidth = 3.0f, viewportHeight = 13.0f).apply {
            path(fill = SolidColor(Color(0xFF727783)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(0.0f, 1.25f)
                curveTo(0.0f, 0.5596f, 0.5596f, 0.0f, 1.25f, 0.0f)
                curveTo(1.9404f, 0.0f, 2.5f, 0.5596f, 2.5f, 1.25f)
                curveTo(2.5f, 1.9404f, 1.9404f, 2.5f, 1.25f, 2.5f)
                curveTo(0.5596f, 2.5f, 0.0f, 1.9404f, 0.0f, 1.25f)
                close()
                moveTo(0.0f, 6.25f)
                curveTo(0.0f, 5.5596f, 0.5596f, 5.0f, 1.25f, 5.0f)
                curveTo(1.9404f, 5.0f, 2.5f, 5.5596f, 2.5f, 6.25f)
                curveTo(2.5f, 6.9404f, 1.9404f, 7.5f, 1.25f, 7.5f)
                curveTo(0.5596f, 7.5f, 0.0f, 6.9404f, 0.0f, 6.25f)
                close()
                moveTo(1.25f, 10.0f)
                curveTo(0.5596f, 10.0f, 0.0f, 10.5596f, 0.0f, 11.25f)
                curveTo(0.0f, 11.9404f, 0.5596f, 12.5f, 1.25f, 12.5f)
                curveTo(1.9404f, 12.5f, 2.5f, 11.9404f, 2.5f, 11.25f)
                curveTo(2.5f, 10.5596f, 1.9404f, 10.0f, 1.25f, 10.0f)
                close()
            }
        }
        .build()
        return _moreVertical!!
    }

private var _moreVertical: ImageVector? = null
