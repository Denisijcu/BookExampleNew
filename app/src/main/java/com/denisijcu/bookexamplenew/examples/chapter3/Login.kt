package com.denisijcu.bookexamplenew.examples.chapter3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun NavGraphff() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") { LoginScreen0(navController) }
        composable("home") { HomeScreenChapter30(navController, "") }


        composable("detailsChapter3/{userName}") { backStackEntry ->
            val userName= backStackEntry.arguments?.getString("userName")
            DetailsScreenChapter30( userName.orEmpty())
        }
    }
}

@Composable
fun HomeScreenChapter30(navController: NavController, userName: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello $userName, click to Navigate Detail Screen")
        Button(onClick = { navController.navigate("detailsChapter3/$userName") }) {
      //  Button(onClick = { navController.navigate("detailsChapter33/$userName") }) {
            Text("Click")
        }
    }
}

@Composable
fun DetailsScreenChapter30(userName: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome $userName. This is the DetailScreen")
    }
}

@Composable
fun LoginScreen0(navController: NavController) {
    var userName by remember { mutableStateOf("") }
    var isAuthenticated by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Login Screen")
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Name") }
        )
        Button(onClick = {
            if (userName.trim() == "goAhead") {
                userName = "John Doe"
                isAuthenticated = true
                navController.navigate("home")
            }
        }) {
            Text("Login")
        }
    }
}
