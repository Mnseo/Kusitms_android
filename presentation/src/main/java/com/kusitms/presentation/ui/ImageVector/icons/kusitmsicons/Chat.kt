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

public val KusitmsIcons.Chat: ImageVector
    get() {
        if (_chat != null) {
            return _chat!!
        }
        _chat = Builder(name = "Chat", defaultWidth = 18.0.dp, defaultHeight = 16.0.dp,
                viewportWidth = 18.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFF727783)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(8.1667f, 0.5f)
                horizontalLineTo(9.8333f)
                curveTo(13.9755f, 0.5f, 17.3333f, 3.8579f, 17.3333f, 8.0f)
                curveTo(17.3333f, 12.1421f, 13.9755f, 15.5f, 9.8333f, 15.5f)
                horizontalLineTo(4.0f)
                curveTo(2.1591f, 15.5f, 0.6667f, 14.0076f, 0.6667f, 12.1667f)
                verticalLineTo(8.0f)
                curveTo(0.6667f, 3.8579f, 4.0245f, 0.5f, 8.1667f, 0.5f)
                close()
                moveTo(9.0f, 8.8333f)
                curveTo(9.4602f, 8.8333f, 9.8333f, 8.4602f, 9.8333f, 8.0f)
                curveTo(9.8333f, 7.5398f, 9.4602f, 7.1667f, 9.0f, 7.1667f)
                curveTo(8.5398f, 7.1667f, 8.1667f, 7.5398f, 8.1667f, 8.0f)
                curveTo(8.1667f, 8.4602f, 8.5398f, 8.8333f, 9.0f, 8.8333f)
                close()
                moveTo(13.1667f, 8.0f)
                curveTo(13.1667f, 8.4602f, 12.7936f, 8.8333f, 12.3333f, 8.8333f)
                curveTo(11.8731f, 8.8333f, 11.5f, 8.4602f, 11.5f, 8.0f)
                curveTo(11.5f, 7.5398f, 11.8731f, 7.1667f, 12.3333f, 7.1667f)
                curveTo(12.7936f, 7.1667f, 13.1667f, 7.5398f, 13.1667f, 8.0f)
                close()
                moveTo(5.6667f, 8.8333f)
                curveTo(6.1269f, 8.8333f, 6.5f, 8.4602f, 6.5f, 8.0f)
                curveTo(6.5f, 7.5398f, 6.1269f, 7.1667f, 5.6667f, 7.1667f)
                curveTo(5.2064f, 7.1667f, 4.8333f, 7.5398f, 4.8333f, 8.0f)
                curveTo(4.8333f, 8.4602f, 5.2064f, 8.8333f, 5.6667f, 8.8333f)
                close()
            }
        }
        .build()
        return _chat!!
    }

private var _chat: ImageVector? = null
