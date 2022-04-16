package com.slaviboy.loaderexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slaviboy.loader.composable.Loader
import com.slaviboy.loader.model.LoaderType
import com.slaviboy.loaderexample.ui.theme.LoaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFe75763)),
                contentAlignment = Alignment.Center
            ) {
                /*Loader(
                    loaderType = LoaderType.HorizontalCirclesLoader(
                        spaceBetweenCircles = 5.dp,
                        circlesRadius = 10.dp,
                        easing = LinearOutSlowInEasing,
                        modifyAlpha = true,
                        modifyX = false,
                        modifyY = false,
                        modifySize = true
                    )
                )*/
                /*Loader(
                    loaderType = LoaderType.HorizontalCirclesLoader(
                        spaceBetweenCircles = 5.dp,
                        circlesRadius = 10.dp,
                        easing = LinearOutSlowInEasing,
                        modifyAlpha = true,
                        modifyX = false,
                        modifyY = true,
                        modifySize = false
                    )
                )*/
                /*Loader(
                    loaderType = LoaderType.HorizontalCirclesLoader(
                        spaceBetweenCircles = 5.dp,
                        circlesRadius = 10.dp,
                        easing = FastOutSlowInEasing,
                        modifyAlpha = false,
                        modifyX = false,
                        modifyY = true,
                        modifySize = false
                    )
                )*/
                /*Loader(
                    loaderType = LoaderType.HorizontalCirclesLoader(
                        spaceBetweenCircles = 5.dp,
                        circlesRadius = 10.dp,
                        easing = FastOutSlowInEasing,
                        modifyAlpha = false,
                        modifyX = false,
                        modifyY = true,
                        modifySize = false,
                        bouncy = false
                    )
                )*/
                /*Loader(
                    loaderType = LoaderType.HorizontalCirclesLoader(
                        spaceBetweenCircles = 5.dp,
                        circlesRadius = 10.dp,
                        easing = LinearOutSlowInEasing,
                        modifyAlpha = true,
                        modifyX = true,
                        modifyY = true,
                        modifySize = false
                    )
                )*/
                /*Loader(
                    loaderType = LoaderType.HorizontalCirclesLoader(
                        spaceBetweenCircles = 5.dp,
                        circlesRadius = 10.dp,
                        easing = LinearEasing,
                        modifyAlpha = false,
                        modifyY = false,
                        modifyX = true,
                        modifySize = false,
                        bouncy = false
                    )
                )*/

                Loader(
                    loaderType = LoaderType.HorizontalCirclesLoader(
                        spaceBetweenCircles = 3.dp,
                        circlesRadius = 5.dp,
                        easing = FastOutSlowInEasing,
                        modifyAlpha = false,
                        modifyX = false,
                        modifyY = true,
                        modifySize = false,
                        bouncy = false,
                        numberOfCircle = 10,
                        yModifyMax = 30.dp
                    )
                )
            }
        }
    }
}




