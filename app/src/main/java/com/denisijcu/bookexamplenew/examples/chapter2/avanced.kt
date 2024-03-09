package com.denisijcu.bookexamplenew.examples.chapter2

import android.widget.GridLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension



import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.runtime.*

import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection

import androidx.compose.ui.unit.sp


/** Examples -/
2.6.1.1 - fillMaxSize() Modifier
 */
@Composable
fun FullSizeBox(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        // Content inside the Box
    }
}

@Preview
@Composable
fun FullSizeBoxPreview() {
   // FullSizeBox()
}


/** Examples -/
2.6.1.2 - sizeIn Modifier
 */
@Composable
fun LimitedSizeBox() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {

        Box(
            modifier = Modifier
                .sizeIn(minWidth = 100.dp, minHeight = 150.dp)
                .background(Color.Green)
        ) {
            // Content inside the Box
        }
    }


}

@Preview
@Composable
fun LimitedSizeBoxPreview() {
   // LimitedSizeBox()
}






/** Examples -/
2.6.2.1 - Layout Composable
 */
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text(
            "Text",
            Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
    }
}


@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    ConstraintLayoutContent()
}

// Basic Constraint Layout:
@Composable
fun ConstrainedLayoutExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (header, content, footer) = createRefs()

        Text(
            text = "Header",
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "Content",
            modifier = Modifier.constrainAs(content) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "Footer",
            modifier = Modifier.constrainAs(footer) {
                top.linkTo(content.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}



@Preview
@Composable
fun ConstrainedLayoutExamplePreview() {
    //ConstrainedLayoutExample()
}

//Responsive Constraint Handling:
@Composable
fun ResponsiveConstraintHandlingExample() {



    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (header, content, footer) = createRefs()

        Text(
            text = "Header",
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "Content",
            modifier = Modifier.constrainAs(content) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = "Footer",
            modifier = Modifier.constrainAs(footer) {
                top.linkTo(content.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview
@Composable
fun ResponsiveConstraintHandlingExamplePreview() {
    //ResponsiveConstraintHandlingExample()
}



/* 2.6.3 - Responsive Design with Jetpack Compose */


@Composable
fun ResponsiveColumnLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Item 1", modifier = Modifier.weight(1f))
        Text("Item 2", modifier = Modifier.weight(4f))
        Text("Item 3", modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun ResponsiveColumnLayoutPreview() {
    ResponsiveColumnLayout()
}


@Composable
fun ResponsiveRowLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Item 1", modifier = Modifier.weight(1f))
        Text("Item 2", modifier = Modifier.weight(2f))
        Text("Item 3", modifier = Modifier.weight(3f))
    }
}


@Preview
@Composable
fun ResponsiveRowLayoutPreview() {
    ResponsiveRowLayout()
}


@Composable
fun ResponsiveGridLayout() {
        LazyVerticalGrid(GridCells.Fixed(3)) {
            items(9) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .background(Color.Gray)
                ) {
                    Text(
                        text = "Item ${index + 1}",
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

}

@Preview
@Composable
fun ResponsiveGridLayoutPreview() {
    ResponsiveGridLayout()
}



// Custom Layout
@Composable
fun CustomConstraintsHandlingExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (header, content, footer) = createRefs()
        Text(
            text = "Header",
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "Content",
            modifier = Modifier.constrainAs(content) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.value(200.dp) // Custom width constraint
            }
        )

        Text(
            text = "Footer",
            modifier = Modifier.constrainAs(footer) {
                top.linkTo(content.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview
@Composable
fun CustomConstraintsHandlingExamplePreview() {
    //CustomConstraintsHandlingExample()
}


@Composable
fun ResponsiveColumnLayoutExample() {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density
    val layoutDirection = LocalLayoutDirection.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(8.dp)
            .clip(shape = shape)
            .background(Color.Gray)
            .padding(8.dp)
            .layoutId(1)

        Text(
            text = "Configuration: $configuration.",
            modifier = modifier.weight(1f),
            fontSize = 18.sp,
            color = Color.White
        )

        Text(
            text = "Density $density",
            modifier = modifier.weight(2f),
            fontSize = 18.sp,
            color = Color.White
        )

        Text(
            text = "Layout direction $layoutDirection",
            modifier = modifier.weight(3f),
            fontSize = 18.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ResponsiveColumnLayoutExamplePreview() {
       // ResponsiveColumnLayoutExample()

}

