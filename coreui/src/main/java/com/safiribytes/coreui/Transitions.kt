package com.safiribytes.coreui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut

private const val AnimationDurationLong = 500
private const val AnimationDurationShort = 300

fun scaleInEnterTransition() = scaleIn(
    initialScale = 0.9f,
    animationSpec = tween(AnimationDurationLong)
) + fadeIn(
    animationSpec = tween(AnimationDurationShort)
)

fun scaleOutExitTransition() = scaleOut(
    targetScale = 1.1f,
    animationSpec = tween(AnimationDurationLong)
) + fadeOut(
   animationSpec = tween(AnimationDurationShort)
)

fun scaleInPopEnterEnterTransition() = scaleIn(
    initialScale = 1.1f,
    animationSpec = tween(AnimationDurationLong)
) + fadeIn(
    animationSpec = tween(AnimationDurationShort)
)

fun scalePopExitTransition() = scaleOut(
    targetScale = 0.9f,
    animationSpec = tween(AnimationDurationLong)
) + fadeOut(
    animationSpec = tween(AnimationDurationShort)
)
