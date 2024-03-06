package com.denisijcu.bookexamplenew.examples.chapter2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.denisijcu.bookexamplenew.ui.theme.BookExampleNewTheme



/**         Index by N.Line      **/
// Example #1 Line = 37    Greeting
// Example #2 Line = 50    Manage State
// Example #3 Line = 80    Material Theme
// Example #4 line = 105   Style Text
// Example #5 line = 131   Style Button
// Example #6 line = 165   Dark Mode
// Example #7 Line = 189   DynamicThemeSwitchingExample


/**
 *
 * Upgrade your project by replacing the MaterialTheme code from the book 'Sculpting Interfaces'
 * with 'BookExampleNewTheme' to enhance the visual aesthetics according to the latest guidelines.
 *
 *
 **/


// Example #1
@Composable
fun Greeting2(name: String) {
    Text(
        text = "Hello, $name!",
        modifier = Modifier.padding(16.dp),
        color = Color.Green,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}


//Example #2
@Composable
fun StateManage(){
// Initialize mutable state
var title by remember { mutableStateOf("Initial Title") }
// Composable UI
Column(
modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)
) {
    // Display the current title
    Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
    // Button to change the title
    Button(onClick = {
        // Update the state when the button is clicked
        title = "New Title ${System.currentTimeMillis()}"
    }) {
        Text("Change Title") } }
}


@Preview(showBackground = true)
@Composable
fun StateManagePreview() {
    BookExampleNewTheme {
     // StateManage()
    }
}

//Example No.3
@Composable
fun MaterialThemeExample(){
    BookExampleNewTheme {
        // Your Compose UI components go here
      Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
      ) {
          Text("Hello, Jetpack Compose!", modifier = Modifier.padding(bottom = 16.dp))
          Button(onClick = { /* Handle button click */ }) {
              Text("Click me")
          }
      }
    }
}
@Preview(showBackground = true)
@Composable
fun MaterialThemeExamplePreview() {
    BookExampleNewTheme {
      //  MaterialThemeExample()
    }
}

// Example No. 4
@Composable
fun StyledTextExample() {
    BookExampleNewTheme {
        // Your Compose UI components go here
        Text(
            text = "Styled Text Example",
            color = Color.Red,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StyledTextExamplePreview() {
    BookExampleNewTheme {
         // StyledTextExample()
    }
}


// Example No. 5
@Composable
fun StyledButtonExample() {
    BookExampleNewTheme {
        // Your Compose UI components go here

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { /* Handle button click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red)
            ) {
                Text(
                    text = "Styled Button",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}


@Preview
@Composable
fun StyledButtonPreview() {
   // StyledButtonExample()
}


// Example No. 6
@Composable
fun DarkModeExample() {
    BookExampleNewTheme(
        darkTheme = true
    ) {
        // Your Compose UI components go here
        Text(
            text = "Dark Mode Example",
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Preview
@Composable
fun DarkModePreview() {
   // DarkModeExample()
}

//Example 7
@Composable
fun DynamicThemeSwitchingExample() {
    var isDarkMode by remember { mutableStateOf(false) }

    BookExampleNewTheme(
        darkTheme = isDarkMode
    ) {
        // Your Compose UI components go here
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = if (isDarkMode) "Dark Mode" else "Light Mode",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = { isDarkMode = !isDarkMode },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Toggle Theme")
            }
        }
    }}


@Preview
@Composable
fun DynamicThemeSwitchingPreview() {
    DynamicThemeSwitchingExample()
}




