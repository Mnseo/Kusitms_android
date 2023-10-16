package com.kusitms.presentation.ui.ImageVector


import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

object LoginTalkBall {
    public var _vector: ImageVector? = null
    val vector: ImageVector
        get() {
            if (_vector != null) {
                return _vector!!
            }
            _vector = ImageVector.Builder(
                name = "vector",
                defaultWidth = 150.dp,
                defaultHeight = 46.dp,
                viewportWidth = 150f,
                viewportHeight = 46f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF266DFC)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(78f, 46f)
                    lineTo(86.6603f, 31f)
                    horizontalLineTo(69.3397f)
                    lineTo(78f, 46f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF266DFC)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(18f, 0f)
                    horizontalLineTo(132f)
                    arcTo(18f, 18f, 0f, isMoreThanHalf = false, isPositiveArc = true, 150f, 18f)
                    verticalLineTo(18f)
                    arcTo(18f, 18f, 0f, isMoreThanHalf = false, isPositiveArc = true, 132f, 36f)
                    horizontalLineTo(18f)
                    arcTo(18f, 18f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 18f)
                    verticalLineTo(18f)
                    arcTo(18f, 18f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18f, 0f)
                    close()
                }
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
                    moveTo(27.0525f, 11.9121f)
                    verticalLineTo(24.1895f)
                    horizontalLineTo(25.7536f)
                    verticalLineTo(17.8184f)
                    horizontalLineTo(23.2243f)
                    verticalLineTo(16.7656f)
                    horizontalLineTo(25.7536f)
                    verticalLineTo(11.9121f)
                    horizontalLineTo(27.0525f)
                    close()
                    moveTo(16.8259f, 20.8125f)
                    curveTo(18.6784f, 19.958f, 19.8952f, 17.8662f, 19.8884f, 15.8496f)
                    verticalLineTo(15.043f)
                    horizontalLineTo(17.1677f)
                    verticalLineTo(14.0039f)
                    horizontalLineTo(19.9021f)
                    verticalLineTo(12.1582f)
                    horizontalLineTo(21.2009f)
                    verticalLineTo(14.0039f)
                    horizontalLineTo(23.8532f)
                    verticalLineTo(15.043f)
                    horizontalLineTo(21.1736f)
                    verticalLineTo(15.8496f)
                    curveTo(21.1736f, 17.7842f, 22.4245f, 19.7734f, 24.3044f, 20.6074f)
                    lineTo(23.5798f, 21.6055f)
                    curveTo(22.1784f, 20.9902f, 21.0984f, 19.7051f, 20.5515f, 18.167f)
                    curveTo(20.0183f, 19.7939f, 18.945f, 21.1611f, 17.5368f, 21.8105f)
                    lineTo(16.8259f, 20.8125f)
                    close()
                    moveTo(34.2936f, 12.1719f)
                    curveTo(36.9802f, 12.165f, 38.6618f, 13.04f, 38.6686f, 14.5234f)
                    curveTo(38.6618f, 15.9795f, 36.9802f, 16.8408f, 34.2936f, 16.834f)
                    curveTo(31.6139f, 16.8408f, 29.9118f, 15.9795f, 29.9186f, 14.5234f)
                    curveTo(29.9118f, 13.04f, 31.6139f, 12.165f, 34.2936f, 12.1719f)
                    close()
                    moveTo(28.7155f, 18.8301f)
                    verticalLineTo(17.7773f)
                    horizontalLineTo(39.8854f)
                    verticalLineTo(18.8301f)
                    horizontalLineTo(28.7155f)
                    close()
                    moveTo(30.0554f, 24.0117f)
                    verticalLineTo(19.9238f)
                    horizontalLineTo(38.5182f)
                    verticalLineTo(24.0117f)
                    horizontalLineTo(30.0554f)
                    close()
                    moveTo(31.2585f, 14.5234f)
                    curveTo(31.2516f, 15.3369f, 32.4069f, 15.8154f, 34.2936f, 15.8223f)
                    curveTo(36.1667f, 15.8154f, 37.3356f, 15.3369f, 37.3288f, 14.5234f)
                    curveTo(37.3356f, 13.6758f, 36.1667f, 13.1904f, 34.2936f, 13.1973f)
                    curveTo(32.4069f, 13.1904f, 31.2516f, 13.6758f, 31.2585f, 14.5234f)
                    close()
                    moveTo(31.3405f, 22.959f)
                    horizontalLineTo(37.2604f)
                    verticalLineTo(20.9629f)
                    horizontalLineTo(31.3405f)
                    verticalLineTo(22.959f)
                    close()
                    moveTo(49.3912f, 12.6504f)
                    curveTo(52.0094f, 12.6572f, 53.9166f, 13.9492f, 53.9166f, 15.9043f)
                    curveTo(53.9166f, 17.7363f, 52.317f, 18.96f, 50.0338f, 19.1445f)
                    verticalLineTo(21.5508f)
                    horizontalLineTo(55.024f)
                    verticalLineTo(22.6309f)
                    horizontalLineTo(43.8131f)
                    verticalLineTo(21.5508f)
                    horizontalLineTo(48.7486f)
                    verticalLineTo(19.1445f)
                    curveTo(46.4791f, 18.96f, 44.8727f, 17.7363f, 44.8795f, 15.9043f)
                    curveTo(44.8727f, 13.9492f, 46.7867f, 12.6572f, 49.3912f, 12.6504f)
                    close()
                    moveTo(46.1373f, 15.9043f)
                    curveTo(46.1373f, 17.2783f, 47.5045f, 18.1328f, 49.3912f, 18.1465f)
                    curveTo(51.2916f, 18.1328f, 52.652f, 17.2783f, 52.6588f, 15.9043f)
                    curveTo(52.652f, 14.5781f, 51.2916f, 13.7031f, 49.3912f, 13.7168f)
                    curveTo(47.5045f, 13.7031f, 46.1373f, 14.5781f, 46.1373f, 15.9043f)
                    close()
                    moveTo(65.9156f, 11.9121f)
                    verticalLineTo(19.0488f)
                    horizontalLineTo(64.6168f)
                    verticalLineTo(16.7383f)
                    horizontalLineTo(62.3062f)
                    verticalLineTo(15.6855f)
                    horizontalLineTo(64.6168f)
                    verticalLineTo(14.3594f)
                    horizontalLineTo(62.3062f)
                    verticalLineTo(13.3066f)
                    horizontalLineTo(64.6168f)
                    verticalLineTo(11.9121f)
                    horizontalLineTo(65.9156f)
                    close()
                    moveTo(55.689f, 17.873f)
                    curveTo(57.6031f, 17.1553f, 58.7173f, 15.4668f, 58.7242f, 13.5938f)
                    verticalLineTo(12.3633f)
                    horizontalLineTo(60.0093f)
                    verticalLineTo(13.5938f)
                    curveTo(60.0093f, 15.3164f, 61.1031f, 16.998f, 62.9488f, 17.6816f)
                    lineTo(62.2105f, 18.707f)
                    curveTo(60.8912f, 18.1875f, 59.9068f, 17.1553f, 59.3804f, 15.8701f)
                    curveTo(58.8541f, 17.251f, 57.8287f, 18.3447f, 56.4136f, 18.8984f)
                    lineTo(55.689f, 17.873f)
                    close()
                    moveTo(56.3863f, 23.0273f)
                    curveTo(57.9517f, 22.4805f, 58.7925f, 21.1816f, 58.8062f, 19.9922f)
                    verticalLineTo(19.4863f)
                    horizontalLineTo(60.0504f)
                    verticalLineTo(19.9922f)
                    curveTo(60.0504f, 21.0518f, 60.5767f, 22.166f, 61.6841f, 22.8428f)
                    curveTo(62.8052f, 22.1113f, 63.3384f, 20.9219f, 63.3453f, 19.9922f)
                    verticalLineTo(19.4863f)
                    horizontalLineTo(64.6168f)
                    verticalLineTo(19.9922f)
                    curveTo(64.6168f, 21.2568f, 65.4507f, 22.5146f, 67.0777f, 23.0273f)
                    lineTo(66.4078f, 23.998f)
                    curveTo(65.2046f, 23.5674f, 64.3843f, 22.7471f, 63.9605f, 21.7354f)
                    curveTo(63.5709f, 22.7197f, 62.8394f, 23.6357f, 61.7046f, 24.1074f)
                    curveTo(60.5357f, 23.6631f, 59.7974f, 22.7881f, 59.4146f, 21.7832f)
                    curveTo(58.9703f, 22.7471f, 58.1705f, 23.5674f, 57.0152f, 23.998f)
                    lineTo(56.3863f, 23.0273f)
                    close()
                    moveTo(77.1353f, 11.9121f)
                    verticalLineTo(16.6562f)
                    horizontalLineTo(79.104f)
                    verticalLineTo(17.7227f)
                    horizontalLineTo(77.1353f)
                    verticalLineTo(24.1895f)
                    horizontalLineTo(75.8364f)
                    verticalLineTo(11.9121f)
                    horizontalLineTo(77.1353f)
                    close()
                    moveTo(68.1118f, 21.1406f)
                    verticalLineTo(13.0879f)
                    horizontalLineTo(73.8404f)
                    verticalLineTo(14.1406f)
                    horizontalLineTo(69.4107f)
                    verticalLineTo(20.0605f)
                    curveTo(71.4683f, 20.0537f, 73.0064f, 19.9648f, 74.7564f, 19.6504f)
                    lineTo(74.9204f, 20.7441f)
                    curveTo(72.9995f, 21.0859f, 71.3726f, 21.1475f, 69.0962f, 21.1406f)
                    horizontalLineTo(68.1118f)
                    close()
                    moveTo(85.73f, 12.9512f)
                    verticalLineTo(13.9902f)
                    horizontalLineTo(88.396f)
                    verticalLineTo(11.9258f)
                    horizontalLineTo(89.6948f)
                    verticalLineTo(20.8535f)
                    horizontalLineTo(88.396f)
                    verticalLineTo(17.6816f)
                    horizontalLineTo(85.73f)
                    verticalLineTo(18.748f)
                    horizontalLineTo(80.0425f)
                    verticalLineTo(12.9512f)
                    horizontalLineTo(85.73f)
                    close()
                    moveTo(81.3276f, 17.7227f)
                    horizontalLineTo(84.4585f)
                    verticalLineTo(14.0039f)
                    horizontalLineTo(81.3276f)
                    verticalLineTo(17.7227f)
                    close()
                    moveTo(81.6968f, 23.9023f)
                    verticalLineTo(20.0332f)
                    horizontalLineTo(83.0093f)
                    verticalLineTo(22.8496f)
                    horizontalLineTo(89.9682f)
                    verticalLineTo(23.9023f)
                    horizontalLineTo(81.6968f)
                    close()
                    moveTo(85.73f, 16.6152f)
                    horizontalLineTo(88.396f)
                    verticalLineTo(15.0566f)
                    horizontalLineTo(85.73f)
                    verticalLineTo(16.6152f)
                    close()
                    moveTo(97.9018f, 12.8281f)
                    curveTo(99.0229f, 12.835f, 99.9389f, 13.4707f, 100.479f, 14.5781f)
                    horizontalLineTo(103.507f)
                    verticalLineTo(11.9121f)
                    horizontalLineTo(104.792f)
                    verticalLineTo(24.1895f)
                    horizontalLineTo(103.507f)
                    verticalLineTo(19.4863f)
                    horizontalLineTo(100.568f)
                    curveTo(100.041f, 20.7168f, 99.0844f, 21.4346f, 97.9018f, 21.4277f)
                    curveTo(96.0766f, 21.4346f, 94.7846f, 19.7666f, 94.7982f, 17.1211f)
                    curveTo(94.7846f, 14.5029f, 96.0766f, 12.835f, 97.9018f, 12.8281f)
                    close()
                    moveTo(96.0287f, 17.1211f)
                    curveTo(96.0355f, 19.0693f, 96.7943f, 20.2656f, 97.9018f, 20.2656f)
                    curveTo(99.0092f, 20.2656f, 99.768f, 19.0693f, 99.7748f, 17.1211f)
                    curveTo(99.768f, 15.2002f, 99.0092f, 13.9971f, 97.9018f, 13.9902f)
                    curveTo(96.7943f, 13.9971f, 96.0355f, 15.2002f, 96.0287f, 17.1211f)
                    close()
                    moveTo(100.848f, 15.6445f)
                    curveTo(100.944f, 16.0957f, 101.005f, 16.5879f, 101.005f, 17.1211f)
                    curveTo(101.005f, 17.5859f, 100.964f, 18.0166f, 100.882f, 18.4199f)
                    horizontalLineTo(103.507f)
                    verticalLineTo(15.6445f)
                    horizontalLineTo(100.848f)
                    close()
                    moveTo(116.655f, 11.9121f)
                    verticalLineTo(24.1621f)
                    horizontalLineTo(115.342f)
                    verticalLineTo(11.9121f)
                    horizontalLineTo(116.655f)
                    close()
                    moveTo(106.592f, 20.8809f)
                    curveTo(109.846f, 19.3291f, 111.439f, 17.1211f, 111.692f, 14.2637f)
                    horizontalLineTo(107.18f)
                    verticalLineTo(13.2246f)
                    horizontalLineTo(113.004f)
                    curveTo(113.004f, 16.8135f, 111.48f, 19.917f, 107.276f, 21.9336f)
                    lineTo(106.592f, 20.8809f)
                    close()
                    moveTo(129.57f, 21.6055f)
                    verticalLineTo(22.6992f)
                    horizontalLineTo(118.359f)
                    verticalLineTo(21.6055f)
                    horizontalLineTo(123.294f)
                    verticalLineTo(19.459f)
                    horizontalLineTo(119.726f)
                    verticalLineTo(15.5625f)
                    horizontalLineTo(126.917f)
                    verticalLineTo(13.8398f)
                    horizontalLineTo(119.699f)
                    verticalLineTo(12.7734f)
                    horizontalLineTo(128.202f)
                    verticalLineTo(16.6016f)
                    horizontalLineTo(121.011f)
                    verticalLineTo(18.3926f)
                    horizontalLineTo(128.49f)
                    verticalLineTo(19.459f)
                    horizontalLineTo(124.579f)
                    verticalLineTo(21.6055f)
                    horizontalLineTo(129.57f)
                    close()
                    moveTo(132.504f, 13.1016f)
                    lineTo(132.381f, 20.1426f)
                    horizontalLineTo(131.028f)
                    lineTo(130.905f, 13.1016f)
                    horizontalLineTo(132.504f)
                    close()
                    moveTo(130.741f, 22.125f)
                    curveTo(130.734f, 21.5918f, 131.178f, 21.1543f, 131.711f, 21.1543f)
                    curveTo(132.238f, 21.1543f, 132.675f, 21.5918f, 132.682f, 22.125f)
                    curveTo(132.675f, 22.6582f, 132.238f, 23.0889f, 131.711f, 23.0957f)
                    curveTo(131.178f, 23.0889f, 130.734f, 22.6582f, 130.741f, 22.125f)
                    close()
                }
            }.build()
            return _vector!!
        }

    @Composable
    fun DrawLoginTalk(modifier: Modifier = Modifier) {
        Image(
            imageVector = vector,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
    }
}