package com.denisijcu.bookexamplenew.examples.chapter2
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex


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

/* PROJECT ADVANCED LAYOUT */

val homeWindow = """
Advanced Layout Techniques and Responsive Design
As your understanding of basic layout components in Jetpack Compose solidifies, it's time to explore advanced techniques for creating responsive and dynamic user interfaces. This section covers handling constraints, applying constraints handling, and achieving a responsive design.
2.6.1 - Handling Constraints in Jetpack Compose
In Jetpack Compose, constraints are crucial for creating layouts that adapt to varying screen sizes and orientations. The Modifier class offers a range of constraints-related modifiers to control the size and positioning of composable elements.    
""".trimIndent()

val layoutWindow = """
    Type some text here about you have learned in this section
""".trimIndent()

val summaryWindow = """
   Mastering advanced layout techniques and responsive design is crucial for building visually appealing and adaptable user interfaces. Whether it's handling constraints, utilizing custom layouts, or ensuring responsiveness, Jetpack Compose empowers developers to create sophisticated UIs that seamlessly adapt to different devices and screen dimensions.

""".trimIndent()


private var isActive:Boolean = false

@Composable
fun AppLayoutAdvancedPractice() {

    var content by remember {
        mutableStateOf(homeWindow)
    }

    var isDrawerBarShow by remember {
        mutableStateOf(false)
    }
    var isSideBarShow by remember {
        mutableStateOf(false)
    }
    var isDialogBxShow by remember {
        mutableStateOf(false)
    }
    var isFootBtnShow by remember {
        mutableStateOf(false)
    }

    if(isDrawerBarShow) DrawerBar()
    if(isSideBarShow) SideBar()
    if(isDialogBxShow) DialogBx()
    if(isFootBtnShow) FootBtn()




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
                                    isSideBarShow = false
                                    isDialogBxShow  = false


                                }, fontSize = 18.sp)
                            Text("Home", modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    content = homeWindow
                                    isDialogBxShow = true

                                }, fontSize = 12.sp)
                            Text("Layout", modifier = Modifier
                                .weight(1f)
                                .clickable { content = layoutWindow }, fontSize = 12.sp)
                            Text("Summary", modifier = Modifier
                                .weight(1f)
                                .clickable { content = summaryWindow }, fontSize = 12.sp)
                            Text("...", modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    isSideBarShow = !isSideBarShow
                                    isDrawerBarShow = false
                                    isDialogBxShow  = false


                                }, fontSize = 12.sp)
                        }
                    }
                    Row(modifier = Modifier
                        .background(Color.Gray)
                        .padding(14.dp)
                        .weight(4f)
                        .verticalScroll(rememberScrollState())) {

                        Text(content,
                            Modifier
                                .background(Color.White)
                                .padding(8.dp))


                    }

                    Row(modifier = Modifier
                        .weight(1f)
                        .align(Alignment.End)) {
                        ConstraintLayout {
                            // Create references for the composables to constrain
                            val (button) = createRefs()

                            Button(
                                onClick = {
                                    content = "All Clear $isDialogBxShow"
                                          isFootBtnShow = !isFootBtnShow
                                          isDialogBxShow = false
                                          isDrawerBarShow = false
                                          isSideBarShow = false
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

}

@Composable
fun DrawerBar() {
    var show by remember {
        mutableStateOf(true)
    }
    if (show) Column(
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
            Column(Modifier.padding(6.dp)) {
                Button(onClick = {
                    show = false

                }) {
                    Text(text = "X")
                }
                Text("Item 1")
                Text("Item 2")


            }

        }
    }
}
@Composable
fun SideBar(){

    var bx by remember {
        mutableStateOf(true)
    }

    if(bx){
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top,
        modifier= Modifier
            .padding(16.dp)
            .zIndex(1f)
            .height(100.dp),



        ) {
        // Utiliza el modificador offset para posicionar el cuadro en (10.dp, 50.dp)
        Box(
            modifier = Modifier
                .absoluteOffset(x = 80.dp, y = 50.dp)
                .background(Color.White)
                .padding(8.dp)
                .size(220.dp, 350.dp)


        ) {
            // Contenido del cuadro
            Column(Modifier.padding(6.dp)) {
                Text("Item 1")
                Text("Item 2")
                Button(onClick = {
                    bx = false

                }) {
                     Text(text = "X")
                }
            }

        }
     }
    }
}

@Composable
fun DialogBx() {

    var show by remember {
        mutableStateOf(true)
    }

    if (show) Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .zIndex(1f)
                .height(100.dp),


            ) {
            // Utiliza el modificador offset para posicionar el cuadro en (10.dp, 50.dp)
            Box(
                modifier = Modifier
                    .background(Color.Magenta)
                    .padding(8.dp)
                    .size(150.dp, 250.dp)


            ) {
                // Contenido del cuadro
                Column(Modifier.padding(6.dp)) {
                    Text("Item 1")
                    Text("Item 2")

                    Button(onClick = {
                        show = false
                    }) {
                        Text("X")

                    }

                }
            }
        }
}



@Composable
fun FootBtn() {

    var show by remember {
        mutableStateOf(true)
    }

    if (show) Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(4.dp,120.dp)
            .zIndex(1f)
            .height(200.dp),


        ) {
        // Utiliza el modificador offset para posicionar el cuadro en (10.dp, 50.dp)
        Box(
            modifier = Modifier
                .background(Color.Cyan)
              //  .absoluteOffset(x = 2.dp, y = 40.dp)
                .padding(8.dp)
                .size(80.dp, 200.dp)


        ) {
            // Contenido del cuadro
            Column(Modifier.padding(6.dp)) {
                Text("Item 1")
                Text("Item 2")

                Button(onClick = {
                    show = false
                }) {
                    Text("X")

                }

            }
        }
    }
}


@Preview
@Composable
fun AppLayoutAdvancedPracticePreview() {
    AppLayoutAdvancedPractice()

}