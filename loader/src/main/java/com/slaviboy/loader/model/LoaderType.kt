package com.slaviboy.loader.model

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class LoaderType {
    data class HorizontalCirclesLoader(
        val bouncy: Boolean = true,
        val modifyAlpha: Boolean = true,
        val modifyY: Boolean = true,
        val modifyX: Boolean = true,
        val modifySize: Boolean = true,
        val animationDuration: Int = 400,
        val easing: Easing = FastOutLinearInEasing,
        val numberOfCircle: Int = 3,
        val spaceBetweenCircles: Dp = 0.dp,
        val circlesRadius: Dp = 3.dp,
        val fillColor: Color = Color.White,
        val strokeColor: Color = Color.Transparent,
        val strokeWidth: Dp = 2.dp,
        val xModifyMax: Dp = circlesRadius,
        val yModifyMax: Dp = circlesRadius
    ) : LoaderType()
}