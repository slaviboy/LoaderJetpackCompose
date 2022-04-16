package com.slaviboy.loader.composable

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import com.slaviboy.loader.model.LoaderType

@Composable
fun HorizontalCirclesLoader(modifier: Modifier, loaderType: LoaderType.HorizontalCirclesLoader) {

    val numberOfCircle = loaderType.numberOfCircle
    if (numberOfCircle < 1) return

    val (circlesRadius,
        spaceBetweenCircles,
        strokeWidth,
        xModifyMax,
        yModifyMax
    ) = with(LocalDensity.current) {
        floatArrayOf(
            loaderType.circlesRadius.toPx(),
            loaderType.spaceBetweenCircles.toPx(),
            loaderType.strokeWidth.toPx(),
            loaderType.xModifyMax.toPx(),
            loaderType.yModifyMax.toPx()
        )
    }
    val circlesDiameter = circlesRadius * 2f
    val (width, height) = with(loaderType) {
        val circleDiameterDp = this.circlesRadius * 2f
        val circlesWidth = circleDiameterDp * (numberOfCircle)
        val spaceBetweenCirclesWidth = this.spaceBetweenCircles * (numberOfCircle - 1)
        listOf((circlesWidth + spaceBetweenCirclesWidth), circleDiameterDp)
    }

    val animationDuration = loaderType.animationDuration
    val easing = loaderType.easing
    val infiniteTransition = rememberInfiniteTransition()
    val sizes = List(numberOfCircle) { i ->
        infiniteTransition.animateFloat(
            initialValue = 0.3f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = animationDuration,
                    easing = easing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(
                    offsetMillis = (animationDuration * 0.5f * (i.toFloat() / (numberOfCircle - 1))).toInt()
                )
            )
        )
    }

    val fillColor = loaderType.fillColor
    val strokeColor = loaderType.strokeColor

    Canvas(
        modifier = modifier
            .width(width)
            .height(height)
    ) {

        for (i in 0 until numberOfCircle) {
            val totalSpaceBetweenCircles = i * (circlesDiameter + spaceBetweenCircles)

            val xModify = if (loaderType.modifyX) {
                if (loaderType.bouncy) {
                    0f
                } else {
                    -(xModifyMax * sizes[i].value)
                }
            } else 0f
            val x = circlesRadius + totalSpaceBetweenCircles + xModify

            val yModify = if (loaderType.modifyY) {
                if (loaderType.bouncy) {
                    if (sizes[i].value > 0.5) {
                        -(yModifyMax * sizes[i].value)
                    } else {
                        (yModifyMax * sizes[i].value)
                    }
                } else {
                    -(yModifyMax * sizes[i].value)
                }
            } else 0f
            val y = circlesRadius + yModify

            val sizeModify = if (loaderType.modifySize) {
                sizes[i].value
            } else 1f
            val radius = circlesRadius * sizeModify

            if (fillColor.alpha > 0f) {
                drawCircle(
                    color = loaderType.fillColor,
                    style = Fill,
                    radius = radius,
                    center = Offset(x, y),
                    alpha = if (loaderType.modifyAlpha) sizes[i].value else 1f
                )
            }

            if (strokeColor.alpha > 0f && strokeWidth > 0f) {
                drawCircle(
                    color = loaderType.strokeColor,
                    style = Stroke(width = strokeWidth),
                    radius = radius,
                    center = Offset(x, y),
                    alpha = if (loaderType.modifyAlpha) sizes[i].value else 1f
                )
            }
        }
    }
}