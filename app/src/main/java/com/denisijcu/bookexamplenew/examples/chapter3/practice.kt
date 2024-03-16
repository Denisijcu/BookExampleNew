package com.denisijcu.bookexamplenew.examples.chapter3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.denisijcu.bookexamplenew.ui.theme.MyTheme
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter


val photos = listOf(
    "https://drive.google.com/uc?id=1PP_gFppleCo2AXevLpp_xMc8QOI-OC9j",
    "https://drive.google.com/uc?id=1NJv2lwIAFpyJP479wG1CR29Cc6h5J0o6",
    "https://drive.google.com/uc?id=1zsEJ9T--MIjPz0YecEtaL7YATkAkp1wE",
    "https://drive.google.com/uc?id=13aKsUMkechNERIex415sXVq-TUOjvhBE",
    "https://drive.google.com/uc?id=1cyKsr0vIwjphN8SmmeDJeWOZZbgG6Rzi",
    "https://drive.google.com/uc?id=1cyKsr0vIwjphN8SmmeDJeWOZZbgG6Rzi",
    "https://drive.google.com/uc?id=1cyKsr0vIwjphN8SmmeDJeWOZZbgG6Rzi",
    "https://drive.google.com/uc?id=1cyKsr0vIwjphN8SmmeDJeWOZZbgG6Rzi",
    "https://drive.google.com/uc?id=1cyKsr0vIwjphN8SmmeDJeWOZZbgG6Rzi",
    "https://drive.google.com/uc?id=1xphOiGwWJGrNhERWPOBp7aHUE4Dy2hDz",
    "https://drive.google.com/uc?id=1zKU1QjvwAZWqThhybsOKl6QB_PxWiRES",
    "https://drive.google.com/uc?id=1d_P_9KTNOpbGVF0yJ2BnVas56f5cKzLe",
    "https://drive.google.com/uc?id=1XTQQ1Pm-E4rne0c4f0AAPgfAFhOK5WK7",
    "https://drive.google.com/uc?id=1XTQQ1Pm-E4rne0c4f0AAPgfAFhOK5WK7",
    "https://drive.google.com/uc?id=14JtlhRZ_CiRJzQ-PBv7UFVI319ToKy6d",
    "https://drive.google.com/uc?id=14FqiRSmp3B7fiDxWUnEwlWejG4hkefQ1",
    "https://drive.google.com/uc?id=1Se9gZZD3JVrmu2QnHqTBENcNdTbpnfsx",
    "https://drive.google.com/uc?id=1pRXYmFdsiftM5xHc6HyApDMfx9VSJQ89"
)


@Composable
fun VerticalGridExample(){
    val  mylist:List<String> = photos

    LazyVerticalGrid(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        columns = GridCells.Adaptive(minSize = 150.dp)
    ) {
     items(mylist) { item ->
         ImageComponent(item)
     }
    }
}

@Composable
fun ImageComponent(imageUrl: String) {
    // Remember the image painter
    val painter = rememberAsyncImagePainter(imageUrl)

    // Display the image
    Image(
        painter = painter,
        contentDescription = "Image from URL",
        modifier = Modifier.height(150.dp).width(150.dp)
    )
}




@Preview(showBackground = true)
@Composable
fun VerticalGridExamplePreview() {
    MyTheme {
        VerticalGridExample()
    }
}


