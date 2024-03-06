package com.denisijcu.bookexamplenew.examples.chapter2

import android.graphics.Paint.Style
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.denisijcu.bookexamplenew.ui.theme.BookExampleNewTheme



/**         Index by N.Line      **/
// Example #1 Line = 37    Greeting                   *****
// Example #2 Line = 50    Manage State
// Example #3 Line = 80    Material Theme
// Example #4 line = 105   Style Text
// Example #5 line = 131   Style Button
// Example #6 line = 165   Dark Mode
// Example #7 Line = 189   DynamicThemeSwitchingExample
// Example #8 Line = 226   VerticalColumnLayout     *****
// Example #9 Line = 249   HorizontalRowLayout
// Example #10 Line = 280  BoxLayout
// Example #10 Line  = 314  WeightedColumnLayout
// PRACTICE LAYOUT  line =345  Practice all basic layout previously discussed in section 2.5

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
    //DynamicThemeSwitchingExample()
}

/*
*  2.5 - Jetpack Compose Layout System
*
* Example #8 VerticalColumnLayout()
*
*/
@Composable
fun VerticalColumnLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Item 1")
        Text("Item 2")
        Text("Item 3")
    }
}



@Preview
@Composable
fun VerticalColumnLayoutPreview() {
   // VerticalColumnLayout()
}

/* Example# 9 */
@Composable
fun HorizontalRowLayout() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Item 1")
        Text("Item 2")
        Text("Item 3")
    }

}



@Preview
@Composable
fun HorizontalLayoutPreview() {
    HorizontalRowLayout()
}



/* Example# 10 */
@Composable
fun BoxLayout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Top", modifier = Modifier.align(Alignment.TopCenter))
        Text("Center", modifier = Modifier.align(Alignment.Center))
        Text("Bottom", modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(50.dp))
    }
}


@Preview
@Composable
fun BoxLayoutPreview() {
   // BoxLayout()
}


/* Example# 11 */
@Composable
fun WeightedColumnLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Item 1", modifier = Modifier.weight(1f))
        Text("Item 2", modifier = Modifier.weight(2f))
        Text("Item 3", modifier = Modifier.weight(3f))
    }
}

@Preview
@Composable
fun WeightedColumnLayoutPreview() {
    WeightedColumnLayout()
}




/**  PRACTICE: Basic struct of Layouts
 *     In this example put in action all the elements already discussed in previous lessons.
 *     Feel Free to updated and free your imagination and try to build something more sophisticated.
 *     Be ready for the Modifier Section in future lesson.
 * */

val home = """
    CHAPTER  2 : Core Concepts
    Understanding Jetpack Compose architecture
 
    In this chapter, we will dive deep into the core concepts that form the foundation of Jetpack Compose. Understanding these concepts is crucial for harnessing the power of Compose to create beautiful and efficient user interfaces.
    
""".trimIndent()

val sections = """
   
   2.1. Declarative UI
   2.1.1 Definition
   Compose utilizes a declarative programming model where the UI is described as a function of the application state. Unlike imperative UI frameworks, developers specify what the UI should look like in different states rather than imperatively defining how to transition between states.
   2.1.2 Advantages
   2.1.3 Syntax
   2.1.3.1. Declarative Syntax:
   2.1.3.2. Type-Safe Builders:
   2.2. Composable Functions
   2.2.1 Overview.
   2.2.2. Function Parameters and Lambdas:
   2.2.3. Property Access Syntax:
   2.3. State management
   2.3.1. Scoped States:
   2.3.2. Smart Defaults and Auto-Inference:
   2.3.3. Threading and Asynchronous Operations:
   2.3.4 Extension Functions:
   2.3.4 DSL for UI Testing:
   2.3.5. Interoperability:
   2.3.6. Preview and Interactive Development:
   2.3.7. Composition
   2.3.8. Reusability
   2.4 -  Theming and styles
   2.4.1. Understanding Themes:
   2.4.1.1 What is a Theme?
   2.4.1.2 Customizing Themes:
   2.4.1.3. Styling Components:
   2.4.1.3.1 Compose UI Elements:
   2.4.1.3.2 Modifiers:
   2.4.3. Dark Mode and Light Mode:
   2.4.3.1 System-wide Themes:
   2.4.3.2 Theme Switching:
   2.4.4. Advanced Theming Techniques:
   2.4.4.1 Custom Themes:
   2.4.4.2 Component-level Styling:
   Examples of  Theming and styles
   2.a - Applying Material Theme:
   2.b- Customizing Themes:
   	2.c -  Styling Components:
   2.c -1 Styling Text Components:
   2.c - 2  Styling Button Components:
   2.d. Dark Mode and Light Mode:
   2.d-1 System-wide Themes:
   2.d -2 Dynamic Theme Switching:
   2.5 - Jetpack Compose Layout System
   2.5.1 - Understanding Columns
   2.5.2 - Working with Rows
   2.5.3 - Using the Box Layout
   2.5.4 - Flexible Layouts with Modifier.weight

""".trimIndent()

val sumary = """
    
    Theming and styles
    
    As we conclude this section on Theming and Styling in Jetpack Compose, you now possess the knowledge to mold your application's visual identity. Whether you embrace the default Material Design aesthetics or forge your own unique style, theming and styling in Jetpack Compose provide the tools for a visually striking and cohesive user interface.
    Experiment, iterate, and let your creativity shine as you embark on the journey of crafting beautiful and intuitive UIs with Jetpack Compose.

    2.5.5 - Summary
    
    Understanding the basics of Column, Row, and Box lays the foundation for creating diverse and responsive layouts in Jetpack Compose. The flexibility offered by these components, combined with powerful modifiers, allows developers to craft UIs that adapt to various screen sizes and orientations.
    In the next section, we'll delve deeper into advanced layout techniques and explore how to handle constraints, constraints handling, and responsive design with Jetpack Compose.

""".trimIndent()


@Composable
fun LayoutBasicPractice(isDark:Boolean) {


    var content by remember {
        mutableStateOf(home)
    }



    BookExampleNewTheme(
        darkTheme = isDark
    ){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {




        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .background(Color.Black)
                .fillMaxWidth(),
        ) {
            Button(
                modifier = Modifier.padding(4.dp),
                onClick = {  content = home },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(isDark) Color.Black else Color.LightGray)
            ) {
                Text(
                    text = "Home",
                    color =if(isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp
                )
            }
            Button(
                modifier = Modifier.padding(4.dp),
                onClick = {  content = sections },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(isDark) Color.Black else Color.LightGray)
            ) {
                Text(
                    text = "Sections",
                    color = if(isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp
                )
            }
            Button(
                modifier = Modifier.padding(4.dp),
                onClick = {  content = sumary },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(isDark) Color.Black else Color.LightGray)
            ) {
                Text(
                    text = "Summary",
                    color = if(isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp
                )
            }

        }

        Row(modifier = Modifier.align(Alignment.Center)){



            Column(
                //verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(2.dp)
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .height(500.dp)

            ) {

                OutlinedCardExample(content)
            }


        }

        Row (
            modifier = Modifier
                .background(Color.Black)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ){
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {
                Text("Powered by: DSL",style = TextStyle(color = Color.White), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
            }

        }

    }}
}


@Composable
fun DynamicThemeSwitching() {
    var isDarkMode by remember { mutableStateOf(true) }

    BookExampleNewTheme(
        darkTheme = isDarkMode
    ) {
        // Your Compose UI components go here
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
           // Text(
            //   text = if (isDarkMode) "Dark Mode" else "Light Mode",
            //   modifier = Modifier.padding(bottom = 16.dp)
            //)
            Button(
                onClick = { isDarkMode = !isDarkMode },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Text("Toggle Theme")
            }

            LayoutBasicPractice(isDarkMode)

        }
    }}

@Composable
fun OutlinedCardExample(text:String) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}
@Preview
@Composable
fun LayoutBasicPracticePreview() {
   // LayoutBasicPractice()
}


