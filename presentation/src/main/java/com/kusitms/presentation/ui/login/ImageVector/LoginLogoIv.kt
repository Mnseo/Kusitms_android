import android.media.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

object LoginLogoIv {
    public var _vector: ImageVector? = null
    val vector: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name =  "vector",
            defaultWidth = 258.dp,
            defaultHeight = 76.dp,
            viewportWidth = 258f,
            viewportHeight = 76f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(36.5899f, 58f)
                horizontalLineTo(25.9519f)
                lineTo(12.8591f, 39.0621f)
                verticalLineTo(58f)
                horizontalLineTo(3.50702f)
                verticalLineTo(17.0848f)
                horizontalLineTo(12.8591f)
                verticalLineTo(34.8537f)
                lineTo(25.3674f, 17.0848f)
                horizontalLineTo(36.0054f)
                lineTo(22.2111f, 37.0164f)
                lineTo(36.5899f, 58f)
                close()
                moveTo(52.9386f, 58.8183f)
                curveTo(43.9372f, 58.8183f, 37.157f, 53.5578f, 37.157f, 44.7902f)
                verticalLineTo(17.0848f)
                horizontalLineTo(46.5091f)
                verticalLineTo(43.9719f)
                curveTo(46.5091f, 47.0698f, 47.9703f, 49.7001f, 52.9386f, 49.7001f)
                curveTo(57.9069f, 49.7001f, 59.3681f, 47.0698f, 59.3681f, 43.9719f)
                verticalLineTo(17.0848f)
                horizontalLineTo(68.7202f)
                verticalLineTo(44.7902f)
                curveTo(68.7202f, 53.5578f, 61.9399f, 58.8183f, 52.9386f, 58.8183f)
                close()
                moveTo(88.9083f, 58.8183f)
                curveTo(80.3161f, 58.8183f, 74.8218f, 54.7268f, 72.5423f, 48.7064f)
                lineTo(80.6084f, 44.0304f)
                curveTo(82.0697f, 47.4205f, 84.583f, 49.7001f, 89.2006f, 49.7001f)
                curveTo(93.6428f, 49.7001f, 94.7534f, 47.9466f, 94.7534f, 46.3684f)
                curveTo(94.7534f, 43.855f, 92.4153f, 42.8614f, 86.2781f, 41.1663f)
                curveTo(80.1992f, 39.4713f, 74.2373f, 36.5488f, 74.2373f, 28.7164f)
                curveTo(74.2373f, 20.8256f, 80.9006f, 16.2665f, 87.9731f, 16.2665f)
                curveTo(94.6949f, 16.2665f, 99.9554f, 19.4813f, 102.936f, 25.5017f)
                lineTo(95.0456f, 30.1192f)
                curveTo(93.6428f, 27.1967f, 91.7139f, 25.3848f, 87.9731f, 25.3848f)
                curveTo(85.0506f, 25.3848f, 83.5894f, 26.846f, 83.5894f, 28.4826f)
                curveTo(83.5894f, 30.353f, 84.583f, 31.6389f, 90.9541f, 33.5678f)
                curveTo(97.1498f, 35.4382f, 104.105f, 37.6009f, 104.105f, 46.2515f)
                curveTo(104.105f, 54.1423f, 97.7928f, 58.8183f, 88.9083f, 58.8183f)
                close()
                moveTo(107.617f, 17.0848f)
                horizontalLineTo(116.969f)
                verticalLineTo(58f)
                horizontalLineTo(107.617f)
                verticalLineTo(17.0848f)
                close()
                moveTo(150.594f, 17.0848f)
                verticalLineTo(26.0862f)
                horizontalLineTo(140.073f)
                verticalLineTo(58f)
                horizontalLineTo(130.721f)
                verticalLineTo(26.0862f)
                horizontalLineTo(120.2f)
                verticalLineTo(17.0848f)
                horizontalLineTo(150.594f)
                close()
                moveTo(194.726f, 17.0848f)
                verticalLineTo(58f)
                horizontalLineTo(185.374f)
                verticalLineTo(34.2107f)
                lineTo(174.795f, 51.5705f)
                horizontalLineTo(173.742f)
                lineTo(163.163f, 34.2107f)
                verticalLineTo(58f)
                horizontalLineTo(153.811f)
                verticalLineTo(17.0848f)
                horizontalLineTo(163.163f)
                lineTo(174.269f, 35.2628f)
                lineTo(185.374f, 17.0848f)
                horizontalLineTo(194.726f)
                close()
                moveTo(214.631f, 58.8183f)
                curveTo(206.039f, 58.8183f, 200.545f, 54.7268f, 198.265f, 48.7064f)
                lineTo(206.331f, 44.0304f)
                curveTo(207.793f, 47.4205f, 210.306f, 49.7001f, 214.923f, 49.7001f)
                curveTo(219.366f, 49.7001f, 220.476f, 47.9466f, 220.476f, 46.3684f)
                curveTo(220.476f, 43.855f, 218.138f, 42.8614f, 212.001f, 41.1663f)
                curveTo(205.922f, 39.4713f, 199.96f, 36.5488f, 199.96f, 28.7164f)
                curveTo(199.96f, 20.8256f, 206.624f, 16.2665f, 213.696f, 16.2665f)
                curveTo(220.418f, 16.2665f, 225.678f, 19.4813f, 228.659f, 25.5017f)
                lineTo(220.768f, 30.1192f)
                curveTo(219.366f, 27.1967f, 217.437f, 25.3848f, 213.696f, 25.3848f)
                curveTo(210.773f, 25.3848f, 209.312f, 26.846f, 209.312f, 28.4826f)
                curveTo(209.312f, 30.353f, 210.306f, 31.6389f, 216.677f, 33.5678f)
                curveTo(222.873f, 35.4382f, 229.828f, 37.6009f, 229.828f, 46.2515f)
                curveTo(229.828f, 54.1423f, 223.516f, 58.8183f, 214.631f, 58.8183f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF266DFC)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 4.8229f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(237f, 38.1282f)
                horizontalLineTo(257.256f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF266DFC)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 4.8229f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(247.129f, 28f)
                lineTo(247.129f, 48.2562f)
            }
        }.build()
        return _vector!!
    }

    @Composable
    fun DrawLogo(modifier: Modifier = Modifier) {
        Image(
            imageVector = vector,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewLoginLogo() {
    LoginLogoIv.DrawLogo()
}