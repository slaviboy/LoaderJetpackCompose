package com.slaviboy.loader.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slaviboy.loader.model.LoaderType

@Composable
fun Loader(
    modifier: Modifier = Modifier,
    loaderType: LoaderType
) {
    if (loaderType is LoaderType.HorizontalCirclesLoader) {
        HorizontalCirclesLoader(modifier = modifier, loaderType = loaderType)
    }
}