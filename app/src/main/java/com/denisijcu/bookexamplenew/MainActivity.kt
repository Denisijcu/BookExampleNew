package com.denisijcu.bookexamplenew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.denisijcu.bookexamplenew.examples.chapter1.Greeting
import com.denisijcu.bookexamplenew.examples.chapter2.AppAnimationPractice
import com.denisijcu.bookexamplenew.examples.chapter2.AppLayoutAdvancedPractice
import com.denisijcu.bookexamplenew.examples.chapter2.BoxLayout
import com.denisijcu.bookexamplenew.examples.chapter2.ConstrainedLayoutExample
import com.denisijcu.bookexamplenew.examples.chapter2.ConstraintLayoutContent
import com.denisijcu.bookexamplenew.examples.chapter2.CustomConstraintsHandlingExample
import com.denisijcu.bookexamplenew.examples.chapter2.DarkModeExample
import com.denisijcu.bookexamplenew.examples.chapter2.DynamicThemeSwitching
import com.denisijcu.bookexamplenew.examples.chapter2.DynamicThemeSwitchingExample
import com.denisijcu.bookexamplenew.examples.chapter2.ExampleScreen
import com.denisijcu.bookexamplenew.examples.chapter2.FadeInAnimation
import com.denisijcu.bookexamplenew.examples.chapter2.FullSizeBox
import com.denisijcu.bookexamplenew.examples.chapter2.Greeting2
import com.denisijcu.bookexamplenew.examples.chapter2.HorizontalRowLayout
import com.denisijcu.bookexamplenew.examples.chapter2.KeyframeAnimation

import com.denisijcu.bookexamplenew.examples.chapter2.LayoutBasicPractice
import com.denisijcu.bookexamplenew.examples.chapter2.LimitedSizeBox
import com.denisijcu.bookexamplenew.examples.chapter2.MaterialThemeExample
import com.denisijcu.bookexamplenew.examples.chapter2.MovingElement
import com.denisijcu.bookexamplenew.examples.chapter2.MovingTextAnimation
import com.denisijcu.bookexamplenew.examples.chapter2.MyApp
import com.denisijcu.bookexamplenew.examples.chapter2.Navigation
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveColumnLayout
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveColumnLayoutExample
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveConstraintHandlingExample
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveGridLayout
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveRowLayout
import com.denisijcu.bookexamplenew.examples.chapter2.ScaleAnimationOnClick
import com.denisijcu.bookexamplenew.examples.chapter2.StateManage
import com.denisijcu.bookexamplenew.examples.chapter2.StyledButtonExample
import com.denisijcu.bookexamplenew.examples.chapter2.StyledTextExample
import com.denisijcu.bookexamplenew.examples.chapter2.VerticalColumnLayout
import com.denisijcu.bookexamplenew.examples.chapter2.WeightedColumnLayout
import com.denisijcu.bookexamplenew.examples.chapter3.ClickableComponent
import com.denisijcu.bookexamplenew.examples.chapter3.CustomStyledButton
import com.denisijcu.bookexamplenew.examples.chapter3.DraggableBox
import com.denisijcu.bookexamplenew.examples.chapter3.GestureDetectionComponent
import com.denisijcu.bookexamplenew.examples.chapter3.HelloContent
import com.denisijcu.bookexamplenew.examples.chapter3.MyAppContent
import com.denisijcu.bookexamplenew.examples.chapter3.MyTextField
import com.denisijcu.bookexamplenew.examples.chapter3.MyUserInterface
import com.denisijcu.bookexamplenew.examples.chapter3.NavGraph
import com.denisijcu.bookexamplenew.examples.chapter3.TextInputComponent
import com.denisijcu.bookexamplenew.ui.theme.BookExampleNewTheme
import com.denisijcu.bookexamplenew.ui.*
import com.denisijcu.bookexamplenew.ui.theme.MyTheme
import com.denisijcu.bookexamplenew.ui.theme.myBg
import kotlinx.coroutines.handleCoroutineException

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

           // val windowSizeClass = calculateWindowSizeClass(this)

            BookExampleNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                   // color = myBg
                ) {



                    /* Un-Check the Composable call function for each example*/

                       /* Chapter #1 */

                         // Greeting("Android")  // Example #1
                         // Greeting2("Android")   //Example #2

                       /* Chapter #2 */

                         // StateManage()    // Example #2
                         // MaterialThemeExample()   //  Examples #3of  Theming and styles
                         // StyledTextExample()  // Example #4
                         //StyledButtonExample()    // Example #5
                         //DarkModeExample()               // Example# 6
                         //DynamicThemeSwitchingExample()  // Example #7
                         // VerticalColumnLayout()         // Example #8
                         //  HorizontalRowLayout()         // Example #9
                         // BoxLayout()                    //Example # 10
                         //WeightedColumnLayout()
                         //LayoutBasicPractice()
                         // DynamicThemeSwitching()

                         /* Chapter #2 */
                              /* Advanced Layout*/

                          //FullSizeBox()
                          // LimitedSizeBox()
                          //ConstraintLayoutContent()
                          //ConstrainedLayoutExample()
                          //ResponsiveConstraintHandlingExample()
                          //CustomConstraintsHandlingExample()
                          // ResponsiveColumnLayout()
                          // ResponsiveRowLayout()
                          //ResponsiveGridLayout()
                          // ResponsiveColumnLayoutExample()
                          //MyApp()
                          //AppLayoutAdvancedPractice()

                           /* Animations   */
                           // FadeInAnimation()
                           // ScaleAnimationOnClick()
                           // KeyframeAnimation()
                           // MovingElement()
                           // MovingTextAnimation()
                           // Project //
                           // AppAnimationPractice()
                           //Navigation()


                           /* Chapter # 3 */

                          // CustomStyledButton()
                          //MyUserInterface()

                         //MyAppContent()
                         //HelloContent()
                         // NavGraph()
                         //ClickableComponent()

                         //TextInputComponent()
                         //GestureDetectionComponent()
                         DraggableBox()







                }
            }
        }
    }
}



@Composable
fun MyAppaa() {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Device Information",
            fontSize = 24.sp,
            color = Color.Black
        )

        Text(
            text = "Screen Width: ${configuration.screenWidthDp} dp",
            fontSize = 18.sp,
            color = Color.Black
        )

        Text(
            text = "Screen Height: ${configuration.screenHeightDp} dp",
            fontSize = 18.sp,
            color = Color.Black
        )

        Text(
            text = "Density: $density",
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun MyAppPreview() {
    MyApp()
}

var isActiveGlobal: Boolean = false
@Composable
fun RoundedCornerColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
            .background(
                color = Color.White,
                shape = MaterialTheme.shapes.small
            )
            .padding(1.dp)
    ) {
        // Your content inside the rounded column
         Btn()

    }
}



class Prop() {
    companion object {
        var myTitle: String = "My App"
            private set
            get() = field

        fun setMyTitle(newTitle:String){
            myTitle = newTitle
        }


        var myState: Boolean = false
            private set
            get() = field

        fun setMyState(newState: Boolean) {
            myState = newState
        }
    }
}

@Composable
fun Btn(){


    var isHomeActive by remember { mutableStateOf(Prop.myState) }
    var title by remember {
        mutableStateOf("Home")
    }




   
       
            Box {
                Column() {

                    Row(Modifier.weight(2f)) {

                        Icon(Icons.Filled.Menu, "Menu")

                        Text("Logo",Modifier.padding(8.dp, 0.dp), color = Color.Black )
                        Text(title, Modifier.weight(2f), color = Color.Black )
                    }

                    Text(" Body ${Prop.myState}  $isHomeActive", Modifier.weight(10f) , color = Color.Black)
                    Column(modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()){


                        Row( modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()) {
                            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                                FloatingActionButton(
                                    onClick = {  }, modifier = Modifier.background(Color.Blue)
                                ) {
                                    Icon(Icons.Filled.Add, "Floating action button.")
                                }
                            }

                        }

                        Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center, modifier = Modifier.weight(1f)) {


                            Text("Learn",
                                Modifier
                                    .padding(50.dp, 0.dp, 0.dp)
                                    .weight(2f)
                                    .clickable {

                                        title = "Learn"
                                        isHomeActive = !isHomeActive
                                        Prop.setMyState(true)


                                    },
                                color = Color.Black)

                            Text("Example",
                                Modifier
                                    .padding(50.dp, 0.dp, 0.dp)
                                    .weight(2f)
                                    .clickable {
                                        title = "Example"
                                        isHomeActive = !isHomeActive
                                        Prop.setMyState(true)


                                    },
                                color = Color.Black)






                            Text("Favorites",

                                Modifier
                                    .padding(50.dp, 0.dp, 0.dp)
                                    .weight(2f)
                                    .clickable {
                                        title = "Favorites"
                                        isHomeActive = !isHomeActive
                                        Prop.setMyState(true)


                                    },
                                color = Color.Black)



                        }




                    }








        }
               if(isHomeActive) Template(title)
                //isHomeActive = !isHomeActive

    }


}
@Composable
fun Template(title:String) {
    var isActive by remember { mutableStateOf(Prop.myState) }

    if(isActive){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp, 0.dp, 0.dp, 0.dp)
            .zIndex(1f)
            .background(
                color = Color.White,
                shape = MaterialTheme.shapes.medium
            )
    ) {
        // Your content inside the rounded column
        Text(title, Modifier.weight(2f), color = Color.Black)
        Text("Body is ${Prop.myState}  $isActive", Modifier.weight(10f), color = Color.Black)
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text("Close",
                Modifier
                    .weight(1f)
                    .clickable {

                        isActive = !isActive

                        Prop.setMyState(false)


                    }, color = Color.Black)
        }

    }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var presses by remember { mutableIntStateOf(0) }

    var myComposable by remember {
        mutableStateOf("Home")

    }

    Scaffold(
        topBar = {
            TopAppBar(

                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {

              //  MyBottomBar()
                /*
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )

                 */
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                """.trimIndent(),
            )

             MyComposable()
        }
    }
}

@Composable
fun MyComposable(){
    Text("Test")
}

@Composable
fun MyBottomBar(navController:NavController){
    Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {


        Text("Learn",
            Modifier
                .padding(50.dp, 0.dp, 0.dp)
                .weight(2f)
                .clickable {

                    Prop.setMyState(true)
                    navController.navigate("home")


                },
            color = Color.Black)

        Text("Example",
            Modifier
                .padding(50.dp, 0.dp, 0.dp)
                .weight(2f)
                .clickable {

                    Prop.setMyState(true)
                    navController.navigate("example")


                },
            color = Color.Black)






        Text("Favorites",

            Modifier
                .padding(50.dp, 0.dp, 0.dp)
                .weight(2f)
                .clickable {

                    Prop.setMyState(true)
                    navController.navigate("favorite")


                },
            color = Color.Black)



    }



}




@Composable
fun ReplyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme =
        if (!darkTheme) {
          //  LightColorScheme
        } else {
           // DarkColorScheme
        }
    MaterialTheme(
       // colorScheme = colorScheme,
        content = content
    )
}

@Preview
@Composable
fun RoundedCornerColumnPreview() {
    Surface(color = Color.White) {
        RoundedCornerColumn()
    }
}

