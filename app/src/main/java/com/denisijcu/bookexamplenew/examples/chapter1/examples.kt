package com.denisijcu.bookexamplenew.examples.chapter1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.denisijcu.bookexamplenew.ui.theme.BookExampleNewTheme

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookExampleNewTheme {
       Greeting("Android")
    }
}