package com.denisijcu.bookexamplenew.examples.chapter3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClickableComponent() {
    var clickCount by remember { mutableIntStateOf(0) }
    Column {
    Box(
        modifier = Modifier
            .clickable {
                clickCount++
            }
            .background(Color.Gray)
            .padding(16.dp)
    ) {

            Text("Click me: $clickCount", color = Color.White)
        }

    }
}

@Composable
fun TextInputComponent() {
    var text by remember { mutableStateOf("Type something") }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Text(text, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal ))
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(18.dp)
        ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text("Enter text") }
        )
    }
}


/**
 * A composable function representing a component that detects gesture input to pan the content horizontally.
 */
@Composable
fun GestureDetectionComponent() {
    var offset by remember { mutableFloatStateOf(0f) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Define a Box with a fixed size and a blue background
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                // Enable pointer input detection on the Box
                .pointerInput(Unit) {
                    // Detect transform gestures (e.g., panning)
                    detectTransformGestures { _, pan: Offset, _, _ ->
                        // Update the offset based on horizontal translation
                        offset += pan.x
                    }
                }
        ) {
            // Display text inside the Box with an offset based on the current offset value
            Text("Pan me!", modifier = Modifier.offset(offset.dp, 0.dp))
        }
    }
}

@Composable
fun DraggableBox() {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Box(
            modifier = Modifier
                .padding(top = 80.dp)
                .graphicsLayer {
                    this.translationX = offsetX
                    this.translationY = offsetY
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
                .size(80.dp)
                .background(if (offsetX > 530f) Color.Red else Color.Magenta)

        )
        Text(text = "Offset X $offsetX \nOffset Y: $offsetY")
        Spacer(modifier = Modifier.height(10.dp))
        DraggableText1()
    }
}

@Composable
fun DraggableText1() {
    Text(
        "Drag me!",
        color = Color.Black,
        textAlign = TextAlign.End,
        modifier = Modifier
            .offset(60.dp, 40.dp)
    )
}
