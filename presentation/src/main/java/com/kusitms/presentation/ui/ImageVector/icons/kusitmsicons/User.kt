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

public val KusitmsIcons.User: ImageVector
    get() {
        if (_user != null) {
            return _user!!
        }
        _user = Builder(name = "User", defaultWidth = 8.0.dp, defaultHeight = 10.0.dp, viewportWidth
                = 8.0f, viewportHeight = 10.0f).apply {
            path(fill = SolidColor(Color(0xFF28303F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(4.0f, 4.5f)
                curveTo(5.1046f, 4.5f, 6.0f, 3.6046f, 6.0f, 2.5f)
                curveTo(6.0f, 1.3954f, 5.1046f, 0.5f, 4.0f, 0.5f)
                curveTo(2.8954f, 0.5f, 2.0f, 1.3954f, 2.0f, 2.5f)
                curveTo(2.0f, 3.6046f, 2.8954f, 4.5f, 4.0f, 4.5f)
                close()
                moveTo(4.0f, 9.5f)
                curveTo(5.933f, 9.5f, 7.5f, 8.6046f, 7.5f, 7.5f)
                curveTo(7.5f, 6.3954f, 5.933f, 5.5f, 4.0f, 5.5f)
                curveTo(2.067f, 5.5f, 0.5f, 6.3954f, 0.5f, 7.5f)
                curveTo(0.5f, 8.6046f, 2.067f, 9.5f, 4.0f, 9.5f)
                close()
            }
        }
        .build()
        return _user!!
    }

private var _user: ImageVector? = null
