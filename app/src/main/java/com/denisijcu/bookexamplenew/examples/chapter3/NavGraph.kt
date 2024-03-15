package com.denisijcu.bookexamplenew.examples.chapter3

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") { LoginScreen3(navController) }

        composable("home/{userName}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -1000 },
                    animationSpec = tween(durationMillis = 1000)
                ) + fadeIn(initialAlpha = 0.3f)
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -1000 },
                    animationSpec = tween(durationMillis = 1000)
                ) + fadeOut(targetAlpha = 0.3f)
            }

        ) { backStackEntry ->
            val userName= backStackEntry.arguments?.getString("userName",)
            HomeScreenChapter3(navController, userName.orEmpty())
        }
        composable("detailsChapter3/{userName}",

            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -1000 },
                    animationSpec = tween(durationMillis = 1000)
                ) + fadeIn(initialAlpha = 0.4f)
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -1000 },
                    animationSpec = tween(durationMillis = 1000)
                ) + fadeOut(targetAlpha = 0.4f)
            }


            ) { backStackEntry ->
            val userName= backStackEntry.arguments?.getString("userName")
            DetailsScreenChapter3( userName.orEmpty())
        }        // Add more destinations as needed
    }
}



@Composable
fun HomeScreenChapter3(navController: NavController, userName: String) {
    // UI components for the home screen
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello $userName, click to  Navigate Detail Screen")
        Button(onClick = { navController.navigate("detailsChapter3/${userName}") }) {
           Text("Click")
        }
    }
}

@Composable
fun DetailsScreenChapter3(useName: String) {
    // Fetch and display details based on itemId
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome $useName. This is the DetailScreen")
    }
}



@Composable
fun LoginScreen3(navController: NavController) {

    var isValidated by remember {
        mutableStateOf(false)
    }

    var notification by remember {
        mutableStateOf("Password, please!")
    }

  var isAuthenticated by remember {
      mutableStateOf(false)
  }
    var userName by remember {
        mutableStateOf("")
    }

    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp))

       {

        //if (userName.isNotEmpty()){
        if (!isValidated){
            Text(text = "Login Screen")
            Text(
                text = "$userName $notification",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Name") }
        )

            Button(onClick = {

                if (userName.trim() == "123") {
                    userName = "John Doe"
                   // isAuthenticated = true
                    isValidated = true
                    navController.navigate("home/$userName")
                }else{
                    notification = "Password failed. Try again."
                }

                // isValidated = !isValidated

            }) {
                Text("click me")
            }
    }
       // }

    }



}


