package com.denisijcu.bookexamplenew.examples.chapter3


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.denisijcu.bookexamplenew.R
import com.denisijcu.bookexamplenew.ui.theme.MyTheme


@Composable
fun MyUserInterface() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Your other UI components can go here
        // Add the custom button to your UI
        CustomStyledButton()

        // Your other UI components can go here
    }
}


@Composable
fun CustomStyledButton() {

        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Click Me",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }


}

@Preview
@Composable
fun MyUserInterfacePreview() {
   // MyUserInterface()
}


@Composable
fun MyAppContent() {



    var countClick by remember {
        mutableIntStateOf(0)
    }

    var myText by remember {
        mutableStateOf("Text Example")
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Example components using the custom theme
        MyLabel("This is a custom label. Count: $countClick")
        MyText("This is a custom text")
        MyTextField(myText)
        MyButton(onClick = {countClick++} )
        MyCard ( myText)


        MyRow {
            MyIcon(Icons.Default.Favorite, contentDescription = "Favorite")
            MyIcon(Icons.Default.MailOutline, contentDescription = "Mail")
            MyIcon(Icons.Default.Send, contentDescription = "Send")
        }
        MyBox {
            Text("Box Content")
        }

        // Include the Image component
        MyImage(R.drawable.ic_mona_lisa) // Replace R.drawable.my_image with your actual image resource
    }


}

@Composable
fun MyLabel(text: String) {
    // Custom Label implementation
    Text(text = text)
}


@Composable
fun MyText(text: String) {
    // Custom Text implementation
    Text(text = text)
}

@Composable
fun MyTextField(value: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        var name by remember { mutableStateOf(value) }
        if (name.isNotEmpty()) {
            Text(
                text = "Hello, $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
    }

}

@Composable
fun MyButton(onClick: () -> Unit) {
    // Custom Button implementation
    Button(onClick = onClick) {
        Text("Click me")
    }
}

@Composable
fun MyCard(text:String) {
    // Custom Card implementation
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun MyRow(content: @Composable () -> Unit) {
    // Custom Row implementation
    
     content.invoke()
}

@Composable
fun MyIcon(imageVector: ImageVector, contentDescription: String) {
    // Custom Icon implementation
    Image(imageVector, contentDescription = contentDescription )
    Text(text = contentDescription)
}

@Composable
fun MyBox(content: @Composable () -> Unit) {
    // Custom Box implementation
    content.invoke()
}

@Composable
fun MyImage(imageResource: Int) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "My Image",
        modifier = Modifier
            .size(200.dp) // Adjust the size as needed
            .background(MaterialTheme.colorScheme.background)
    )
}



@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyTheme {
        MyAppContent()
    }
}




