package com.denisijcu.bookexamplenew.examples.chapter2


//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.denisijcu.bookexamplenew.MyBottomBar
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    var title by remember { mutableStateOf("My App") }

    data class BarItem(
        val title: String,
        val image: ImageVector,
        val route: String
    )

    val barItems = listOf(
        BarItem(title = "Home", image = Icons.Filled.Home, route = "home"),
        BarItem(title = "Examples", image = Icons.Filled.List, route = "examples"),
        BarItem(title = "Gallery", image = Icons.Filled.Face, route = "gallery")
    )

    val items = mutableListOf(
        "Home" to { navController.navigate("home") to Icons.Filled.Home },
        "Example" to { navController.navigate("example") to Icons.Filled.MailOutline },
        "Favorite" to { navController.navigate("favorite") to Icons.Default.Favorite },
        "Settings" to { null to Icons.Default.AccountBox },
        "Help" to { null to Icons.Default.Check },
        "Exit" to {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Exit Clicked")
            }
        }
    )

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(
                backgroundColor = Magenta, // Set the desired background color
                contentColor = Color.White,
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        drawerContent = {
            Column(Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "This is my App",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5
                )
                Divider()

                Row{
                    IconButton(onClick = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                            navController.navigate("home")
                        }
                    }) {
                        Icon(Icons.Default.Home, contentDescription = null)

                    }
                    Text(text = "Home", Modifier.padding(0.dp, 16.dp).clickable {
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                            navController.navigate("home")
                        }
                    })
                }
                Row {

                IconButton(onClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                        navController.navigate("favorite")
                    }
                }) {
                    Icon(Icons.Default.Favorite, contentDescription = null)

                }
                Text(text = "Favorite",  Modifier.padding(0.dp, 16.dp))
                }

                 Row {
                     IconButton(onClick = {
                         coroutineScope.launch {
                             scaffoldState.drawerState.close()
                             navController.navigate("example")
                         }
                     }) {
                         Icon(Icons.Default.Face, contentDescription = null)

                     }
                     Text(text = "Example", Modifier.padding(0.dp, 16.dp))

                 }


            }
        },
        bottomBar = {
            MyBottomBar(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("example") },
                containerColor = Color.Magenta
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = {
            NavHost(navController, startDestination = "home") {
                composable("home") {
                    title = "Home"
                    HomeScreen()
                }
                composable("example") {
                    title = "Example"
                    ExampleScreen()
                }
                composable("favorite") {
                    title = "Favorite"
                    FavoriteScreen()
                }
            }
        }
    )
}

@Composable
fun HomeScreen() {
    Text(
        modifier = Modifier.padding(16.dp),
        text = "Home Screen Content"
    )
}

@Composable
fun ExampleScreen() {
    Text(
        modifier = Modifier.padding(16.dp),
        text = "Example Screen Content"
    )
}

@Composable
fun FavoriteScreen() {
    Text(
        modifier = Modifier.padding(16.dp),
        text = "Favorite Screen Content"
    )
}
