package com.denisijcu.bookexamplenew.examples.chapter2

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput


import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt


/*   Examples of the book */
@Composable
fun FadeInAnimation() {
    var isVisible by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {

        Column() {
            if (isVisible) {
                Text(
                    text = "Fade In Animation",
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .alpha(animateFloatAsState(targetValue = 3f, label = "").value)
                )
            }
        }
    }
}

@Preview
@Composable
fun FadeInAnimationPreview() {
    FadeInAnimation()

}

@Composable
fun ScaleAnimationOnClick() {
    var isScaled by remember { mutableStateOf(false) }
    var bgColor by remember {
        mutableStateOf(Color.Blue)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        val scale by animateFloatAsState(
            targetValue = if (isScaled) 2f else 1f,
            animationSpec = spring(stiffness = Spring.StiffnessLow), label = ""
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .graphicsLayer(scaleX = scale, scaleY = scale)
                .clip(shape)
                .background(bgColor)
                .clickable {
                    isScaled = !isScaled

                    bgColor = if (!isScaled) Color.Blue else Color.LightGray
                }
        )
        Text("Click Me")
    }
}
@Preview
@Composable
fun ScaleAnimationOnClickPreview() {
    ScaleAnimationOnClick()
}


@Composable
fun KeyframeAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Black,
        targetValue = Color.LightGray,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text("Color Changing Text ", color = Color.White, fontSize = 24.sp)
    }
}


@Preview
@Composable
fun KeyframeAnimationPreview() {
    KeyframeAnimation()
}

@Composable
fun MovingTextAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 2f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "scale"
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "On Sale 50%", fontSize = 10.sp,
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    transformOrigin = TransformOrigin.Center
                }
                .align(Alignment.Center),
            // Text composable does not take TextMotion as a parameter.
            // Provide it via style argument but make sure that we are copying from current theme
            style = LocalTextStyle.current.copy(textMotion = TextMotion.Animated)
        )
    }
}

@Preview
@Composable
fun MovingTextAnimationPreview() {
   // MovingTextAnimation()
}


@Composable
fun MovingElement() {
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    var positionX by remember { mutableStateOf("") }
    var positionY by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(Color.Blue)
                .size(50.dp)
                .pointerInput(Unit) {
                    detectTransformGestures { _: Offset, offset1: Offset, _: Float, _: Float ->
                        offsetX += offset1.x
                        offsetY += offset1.y
                    }
                }
        )
        positionX = if(offsetX>1) "Right" else "Left"
        positionY = if(offsetY<1) "Up" else "Down"
        positionX = if(offsetX.toInt() ==0) "Center" else positionX
        positionY = if(offsetY.toInt() == 0) "Up" else positionY

        Text("Screen Position $positionX  $positionY")
    }


/*
    detectTransformGestures { _, pan ->
        when (pan) {
            is PanGesture.Pan -> {
                offsetX += pan.delta.x
                offsetY += pan.delta.y
            }
            // Handle other gesture cases if needed
            else -> Unit
        }
    }
*/
}


@Preview
@Composable
fun MovingTextAnimationPreviewPreview() {
    MovingTextAnimationPreview()
}


