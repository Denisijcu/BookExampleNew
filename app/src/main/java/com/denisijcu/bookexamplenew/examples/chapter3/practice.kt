package com.denisijcu.bookexamplenew.examples.chapter3

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.denisijcu.bookexamplenew.ui.theme.MyTheme
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch


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
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)
    )
}




@Preview(showBackground = true)
@Composable
fun VerticalGridExamplePreview() {
    MyTheme {
       // VerticalGridExample()
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottom(){
    val sheetState = rememberModalBottomSheetState()
    val contentPadding = 8.dp
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
   // var isShowWindow by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Open") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) {


        // Screen content

        if(showBottomSheet) ShowWindow()



        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                // Sheet content
                /*
                Button(onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                }) {
                    Text("Close")
                }*/
                Box(
                    modifier = Modifier.clickable {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }
                ){
                    Text("")
                }
            }
        }
    }


}

@Composable
fun ShowWindow(){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.height(400.dp)
    ) {
        Text("This is a window")
    }
}

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
            Button(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.Blue)
            ) {
                Text(text = text, color = Color.White)
            }
        }
}

@Composable
fun TestingCustomButton(){
    var textState = remember {
        mutableStateOf("Click Me")
    }
    val clickMe = {  ->
        if (textState.value =="Hey there!")
            textState.value = "Click Me"
        else textState.value ="Hey there!"
    }
    CustomButton(textState.value, clickMe )
    Text("Ok ${textState.value}")
    Spacer(modifier = Modifier.height(100.dp))
}

@Preview(showBackground = true)
@Composable
fun TestingCustomButtonPreview() {
    MyTheme {
       // TestingCustomButton()
    }
}

@Composable
fun ElevatedCardExample(
    title: String,
    content: String

) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 300.dp)
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = content)
        }
    }
}

@Composable
fun TestingElevatedCard(){

    val title = "Elevated Card"
    val content = "This is the content"

    ElevatedCardExample(title, content)


}

@Preview(showBackground = true)
@Composable
fun TestingElevatedCardPreview() {
    MyTheme {
       // TestingElevatedCard()
    }
}

@Composable
fun PersonalizedCard(
    title: String,
    content: String,
    backgroundColor: Color,
    textColor: Color
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation( defaultElevation = 6.dp),
        modifier = Modifier
            //.fillMaxWidth()
            .padding(16.dp)
            .size(250.dp, 150.dp)
            .height(255.dp)
            .width(155.dp)
            .background(backgroundColor)

        ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp)
                .background(Color.White)

        ) {
            Text(text = title, color = textColor, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = content, color = textColor)
        }
    }
}


@Composable
fun TestingPersonalizedCard(){

    val title = "Elevated Card"
    val content = "This is the content"

    PersonalizedCard( title,content,Color.White,Color.Blue)
}


@Preview(showBackground = true)
@Composable
fun TestingPersonalizedCardPreview() {
    MyTheme {
        TestingPersonalizedCard()
    }
}














