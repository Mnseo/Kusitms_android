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

public val KusitmsIcons.Download: ImageVector
    get() {
        if (_download != null) {
            return _download!!
        }
        _download = Builder(name = "Download", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFD9DCE1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.7167f, 18.5417f)
                horizontalLineTo(7.2833f)
                curveTo(3.1916f, 18.5417f, 1.4417f, 16.7917f, 1.4417f, 12.7001f)
                verticalLineTo(12.5917f)
                curveTo(1.4417f, 8.8917f, 2.9f, 7.1084f, 6.1666f, 6.8001f)
                curveTo(6.5f, 6.7751f, 6.8166f, 7.0251f, 6.85f, 7.3667f)
                curveTo(6.8833f, 7.7084f, 6.6333f, 8.0167f, 6.2833f, 8.0501f)
                curveTo(3.6667f, 8.2917f, 2.6916f, 9.5251f, 2.6916f, 12.6001f)
                verticalLineTo(12.7084f)
                curveTo(2.6916f, 16.1001f, 3.8916f, 17.3001f, 7.2833f, 17.3001f)
                horizontalLineTo(12.7167f)
                curveTo(16.1083f, 17.3001f, 17.3083f, 16.1001f, 17.3083f, 12.7084f)
                verticalLineTo(12.6001f)
                curveTo(17.3083f, 9.5084f, 16.3166f, 8.2751f, 13.65f, 8.0501f)
                curveTo(13.3083f, 8.0167f, 13.05f, 7.7167f, 13.0833f, 7.3751f)
                curveTo(13.1166f, 7.0334f, 13.4083f, 6.7751f, 13.7583f, 6.8084f)
                curveTo(17.075f, 7.0917f, 18.5583f, 8.8834f, 18.5583f, 12.6084f)
                verticalLineTo(12.7167f)
                curveTo(18.5583f, 16.7917f, 16.8083f, 18.5417f, 12.7167f, 18.5417f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD9DCE1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.0f, 13.0248f)
                curveTo(9.6583f, 13.0248f, 9.375f, 12.7415f, 9.375f, 12.3998f)
                verticalLineTo(1.6665f)
                curveTo(9.375f, 1.3248f, 9.6583f, 1.0415f, 10.0f, 1.0415f)
                curveTo(10.3417f, 1.0415f, 10.625f, 1.3248f, 10.625f, 1.6665f)
                verticalLineTo(12.3998f)
                curveTo(10.625f, 12.7498f, 10.3417f, 13.0248f, 10.0f, 13.0248f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD9DCE1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.0f, 13.9585f)
                curveTo(9.8417f, 13.9585f, 9.6834f, 13.9002f, 9.5584f, 13.7752f)
                lineTo(6.7667f, 10.9835f)
                curveTo(6.525f, 10.7419f, 6.525f, 10.3419f, 6.7667f, 10.1002f)
                curveTo(7.0084f, 9.8585f, 7.4084f, 9.8585f, 7.65f, 10.1002f)
                lineTo(10.0f, 12.4502f)
                lineTo(12.35f, 10.1002f)
                curveTo(12.5917f, 9.8585f, 12.9917f, 9.8585f, 13.2334f, 10.1002f)
                curveTo(13.475f, 10.3419f, 13.475f, 10.7419f, 13.2334f, 10.9835f)
                lineTo(10.4417f, 13.7752f)
                curveTo(10.3167f, 13.9002f, 10.1584f, 13.9585f, 10.0f, 13.9585f)
                close()
            }
        }
        .build()
        return _download!!
    }

private var _download: ImageVector? = null
