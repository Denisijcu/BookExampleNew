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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
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
   // MovingTextAnimationPreview()
}


/**

App to apply the different animation discussed in Animation Section

 **/

/* PROJECT ADVANCED LAYOUT */

val homeWindowAnimated = """
2.7 - Exploring Animations and Motion in Jetpack Compose
2.7.1 - Basics of Animation in Jetpack Compose
In Jetpack Compose, animations are achieved using the animate* functions, which allow you to transition between different states smoothly. The basic structure of an animation involves specifying the target property, the animation duration, and the easing curve.
   
""".trimIndent()

val layoutWindowAnimated = """
    2.7.1.1 - Simple Fade-In Animation
    2.7.1.2 - Scale Animation on Click
    2.7.2 - Advanced Animation with Keyframes
    2.7.3 - Motion with Modifier.offset
    2.7.3.1 - Moving Text Animation



""".trimIndent()

val summaryWindowAnimated = """
 2.7.4 - Summary
Animations and motion bring life to your Jetpack Compose UI, making it more interactive and visually appealing. Whether you're creating simple fade-ins, scaling effects, or complex keyframe animations, Compose's declarative approach makes it intuitive to incorporate dynamic elements into your app.

""".trimIndent()


private var isActive:Boolean = false

@Composable
fun AppAnimationPractice() {

    var isVisible by remember { mutableStateOf(true) }

    var content by remember {
        mutableStateOf(homeWindowAnimated)
    }

    var isDrawerBarShow by remember {
        mutableStateOf(false)
    }
    /*
    var isSideBarShow by remember {
        mutableStateOf(false)
    }
    var isDialogBxShow by remember {
        mutableStateOf(false)
    }
    var isFootBtnShow by remember {
        mutableStateOf(false)
    }
*/



    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(4.dp)){

            Row(modifier = Modifier.weight(1f)){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text("= Logo", modifier = Modifier
                        .weight(1f)
                        .clickable {
                            isDrawerBarShow = !isDrawerBarShow
                            isVisible = true


                        }, fontSize = 18.sp)


                        Text("Home", modifier = Modifier

                            .weight(1f)
                            .clickable {
                                content = homeWindowAnimated
                                isVisible = true

                            }, fontSize = 12.sp)


                        Text("Layout", modifier = Modifier
                            .weight(1f)
                            .clickable {
                                content = layoutWindowAnimated
                                isVisible = true
                            }, fontSize = 12.sp
                        )


                        Text("Summary", modifier = Modifier
                            .weight(1f)
                            .clickable {
                                content = summaryWindowAnimated
                                isVisible = true
                            }, fontSize = 12.sp
                        )


                    Text("...", modifier = Modifier
                        .weight(1f)
                        .clickable {
                            isDrawerBarShow = !isDrawerBarShow
                            isVisible = true


                        }, fontSize = 12.sp)
                }
            }
            Row(modifier = Modifier
                .background(Color.Gray)
                .padding(14.dp)
                .weight(4f)
                .verticalScroll(rememberScrollState())) {
                if (isVisible) {
                    Text(
                        content,
                        Modifier
                            .alpha(animateFloatAsState(targetValue = 3f, label = "").value)
                            .background(Color.White)
                            .padding(8.dp)
                    )
                }

            }

            Row(modifier = Modifier
                .weight(1f)
                .align(Alignment.End)) {
                ConstraintLayout {
                    // Create references for the composables to constrain
                    val (button) = createRefs()

                    Button(
                        onClick = {
                            isDrawerBarShow = !isDrawerBarShow
                            isVisible = true
                        },
                        // Assign reference "button" to the Button composable
                        // and constrain it to the top of the ConstraintLayout
                        modifier = Modifier.constrainAs(button) {
                            top.linkTo(parent.top, margin = 16.dp)
                        }
                    ) {
                        Text("=", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }

                }
            }


        }


    }


    /* Drawer Navigation Window */


    var e1 by remember { mutableStateOf(false) }
    var e2 by remember { mutableStateOf(false) }
    var e3 by remember { mutableStateOf(false) }
    var e4 by remember { mutableStateOf(false) }
    var e5 by remember { mutableStateOf(false) }

    if (isDrawerBarShow) Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier= Modifier
            .padding(4.dp)
            .zIndex(1f)
            .height(100.dp),



        ) {
        // Utiliza el modificador offset para posicionar el cuadro en (10.dp, 50.dp)
        Box(
            modifier = Modifier
                .absoluteOffset(x = 2.dp, y = 40.dp)
                .background(Color.White)
                .padding(0.dp)
                .size(220.dp, 350.dp)


        ) {
            // Contenido del cuadro
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End,

                modifier =Modifier.padding(6.dp)) {
                Button(onClick = {
                    isDrawerBarShow = false
                    e1 = false
                    e2 = false
                    e3 = false
                    e4 = false
                    e5 = false

                }) {
                    Text(text = "X")
                }


                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,){
                    Text("Simple Fade-In Animation",modifier = Modifier.clickable {
                        e1 = true
                    })
                    Text("Scale Animation on Click",modifier = Modifier.clickable {
                        e2 = true
                    })
                    Text("Advanced Animation with Keyframes",modifier = Modifier.clickable {
                        e3 = true
                    })
                    Text("Motion with Modifier.offset",modifier = Modifier.clickable {
                        e4 = true
                    })
                    Text("Moving Text Animation",modifier = Modifier.clickable {
                        e5 = true
                    })
                }




            }

        }
    }


    if(e1) FadeInAnimation()
    if(e2) ScaleAnimationOnClick()
    if(e3) KeyframeAnimation()
    if(e4) MovingTextAnimation()
    if(e5) MovingElement()


}


@Preview
@Composable
fun AppAnimationPracticePreview() {
    AppAnimationPractice()

}


