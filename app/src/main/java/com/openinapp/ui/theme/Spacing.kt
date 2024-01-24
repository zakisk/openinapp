package com.openinapp.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val zero: Dp = 0.dp,
    val tiny: Dp = 2.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val XL: Dp = 32.dp,
    val XXL: Dp = 40.dp,
    val XXXL: Dp = 48.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }