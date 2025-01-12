package com.shubhans.core.presentation.design_system

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val default: Dp = 0.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 20.dp,
    val spaceLarge: Dp = 34.dp,
    val spaceExtraLarge: Dp = 64.dp
)

val LocalSpacing = compositionLocalOf { Dimensions() }