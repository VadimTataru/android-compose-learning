package com.fox.composelearning.screens

import android.content.Context
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context: Context) {
    val navController = rememberNavController()
    val bottomItems = listOf("list", "search", "push")

    Scaffold(
        //modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                bottomItems.forEach { screen ->
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate(screen) },
                        label = { Text(screen) },
                        icon = {}
                    )
                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "list") {
            composable("list") { ListScreen(navController, context) }
            composable("search") { SearchScreen() }
            composable("push") { PushScreen() }
            composable("details") {
                navController.previousBackStackEntry?.arguments?.getParcelable<Word>("WORD_KEY")?.let {
                    DetailsScreen(it)
                }
            }
        }
    }
}