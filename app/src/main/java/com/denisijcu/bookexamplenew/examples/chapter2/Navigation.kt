package com.denisijcu.bookexamplenew.examples.chapter2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            NavHome(navController)
        }
        composable("details/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            DetailsScreen(itemId)
        }
    }
}

@Composable
fun NavHome(navController: NavHostController) {
    var offset by remember { mutableStateOf(0f) }
    var id by remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

    ) {
        Text("Home Screen")

        Text(
            text = "Click increase id: $id",
            modifier = Modifier.clickable {
                id++
            }
        )


        Button(
            modifier = Modifier.offset(x = offset.dp, y = 0.dp),

        onClick = { navController.navigate("details/${id}") }) {
            Text("Click Me")
        }


    }

}
@Composable
fun DetailsScreen(itemId: String?) {


    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) ){

        val res = when (itemId?.toInt()) {
            0 -> "Hey!"
            1 -> " What's up?"
            2 -> "Are you ok?"
            3 -> "Jetpack compose is nice"
            4 -> "Kotlin is great!"
            else -> "Out of range"
        }

        Text("Detail Screen $itemId")
        Text(res)


    }
}




