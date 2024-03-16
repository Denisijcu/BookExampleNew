package com.denisijcu.bookexamplenew.examples.chapter3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.denisijcu.bookexamplenew.ui.theme.MyTheme

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (button1, button2, button3) = createRefs()

        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Text("Button 1")
        }

        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(button1.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Text("Button 2")
        }

        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.constrainAs(button3) {
                top.linkTo(button2.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Text("Button 3")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutExamplePreview() {
    MyTheme {
        //ConstraintLayoutExample()
    }
}




@Composable
fun FlexboxLayoutExample(items: List<String>) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Gray)
                    .padding(16.dp)
            ) {
                Text(item, color = Color.White)
            }
        }
    }
}


@Composable
fun GridItemSpanExample() {
    // [START android_compose_layouts_lazy_vertical_grid_full_span]
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 30.dp)
    ) {
        item(span = {
            // LazyGridItemSpanScope:
            // maxLineSpan
            GridItemSpan(maxLineSpan)
        }) {
            CategoryCard("Fruits")
        }
        // ...
    }
    // [END android_compose_layouts_lazy_vertical_grid_full_span]
}

@Composable
fun CategoryCard(s: String) {
      Text(text = s)
}

class Item(a:Int=2,b:Int = 1)
@Composable
fun LazyGridMultipleElements_Avoid() {
    // Avoid combining items that are logically different items, as they are handled as one
    // entity now, it can hurt performance. It'll also interfere with methods such as
    // scrollToItem()
    // [START android_compose_layouts_lazy_grid_multiple_elements]
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(myList) { item ->
           // Text(item)
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(myList) { photo ->
           Text(photo)
        }
    }

}
    // [END android_compose_layouts_lazy_grid_multiple_elements]


private val myList = listOf(
   "A","B","C","D","E","F","G","H"
)

@Composable
fun CustomGridExample() {
    val items = List(12) { index -> "Item $index" }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(120.dp)) {
        items(items) { item ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Gray)
                    .padding(16.dp)
            ) {
                Text(item, color = Color.White)
            }
        }
    }
}


@Composable
fun ResponsiveConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (header, content) = createRefs()

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
                .constrainAs(header) {
                    top.linkTo(parent.top)
                }
        ) {
            Text("Header", color = Color.White)
        }

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize()
                .padding(16.dp)
                .constrainAs(content) {
                    top.linkTo(header.bottom, margin = 16.dp)
                }
        ) {
            Text("Content")
        }
    }
}



