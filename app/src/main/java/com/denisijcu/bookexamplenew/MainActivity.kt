package com.denisijcu.bookexamplenew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.denisijcu.bookexamplenew.examples.chapter1.Greeting
import com.denisijcu.bookexamplenew.examples.chapter2.DarkModeExample
import com.denisijcu.bookexamplenew.examples.chapter2.DynamicThemeSwitchingExample
import com.denisijcu.bookexamplenew.examples.chapter2.Greeting2
import com.denisijcu.bookexamplenew.examples.chapter2.MaterialThemeExample
import com.denisijcu.bookexamplenew.examples.chapter2.StateManage
import com.denisijcu.bookexamplenew.examples.chapter2.StyledButtonExample
import com.denisijcu.bookexamplenew.examples.chapter2.StyledTextExample
import com.denisijcu.bookexamplenew.ui.theme.BookExampleNewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                         //DarkModeExample()    // Example# 6
                         DynamicThemeSwitchingExample()  // Example #7

                }
            }
        }
    }
}



