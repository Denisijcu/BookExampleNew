package com.denisijcu.bookexamplenew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.denisijcu.bookexamplenew.examples.chapter1.Greeting
import com.denisijcu.bookexamplenew.examples.chapter2.AppLayoutAdvancedPractice
import com.denisijcu.bookexamplenew.examples.chapter2.BoxLayout
import com.denisijcu.bookexamplenew.examples.chapter2.ConstrainedLayoutExample
import com.denisijcu.bookexamplenew.examples.chapter2.ConstraintLayoutContent
import com.denisijcu.bookexamplenew.examples.chapter2.CustomConstraintsHandlingExample
import com.denisijcu.bookexamplenew.examples.chapter2.DarkModeExample
import com.denisijcu.bookexamplenew.examples.chapter2.DynamicThemeSwitching
import com.denisijcu.bookexamplenew.examples.chapter2.DynamicThemeSwitchingExample
import com.denisijcu.bookexamplenew.examples.chapter2.FullSizeBox
import com.denisijcu.bookexamplenew.examples.chapter2.Greeting2
import com.denisijcu.bookexamplenew.examples.chapter2.HorizontalRowLayout

import com.denisijcu.bookexamplenew.examples.chapter2.LayoutBasicPractice
import com.denisijcu.bookexamplenew.examples.chapter2.LimitedSizeBox
import com.denisijcu.bookexamplenew.examples.chapter2.MaterialThemeExample
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveColumnLayout
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveColumnLayoutExample
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveConstraintHandlingExample
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveGridLayout
import com.denisijcu.bookexamplenew.examples.chapter2.ResponsiveRowLayout
import com.denisijcu.bookexamplenew.examples.chapter2.StateManage
import com.denisijcu.bookexamplenew.examples.chapter2.StyledButtonExample
import com.denisijcu.bookexamplenew.examples.chapter2.StyledTextExample
import com.denisijcu.bookexamplenew.examples.chapter2.VerticalColumnLayout
import com.denisijcu.bookexamplenew.examples.chapter2.WeightedColumnLayout
import com.denisijcu.bookexamplenew.ui.theme.BookExampleNewTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val windowSizeClass = calculateWindowSizeClass(this)

            BookExampleNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
                        AppLayoutAdvancedPractice()




                }
            }
        }
    }
}



@Composable
fun MyApp() {
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

