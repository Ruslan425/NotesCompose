package ru.romazanov.notescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.screens.AddScreen
import ru.romazanov.notescompose.screens.MainScreen
import ru.romazanov.notescompose.screens.NoteScreen
import ru.romazanov.notescompose.screens.StartScreen


@Composable
fun NavHostControler(

) {
    val navController = rememberNavController()
    val viewModel = MainVM()

    NavHost(navController = navController, startDestination = Screen.StartScreen.route) {

        composable(Screen.StartScreen.route) {
            StartScreen(navHostController = navController, viewModel)
        }
        composable(Screen.AddScreen.route) {
            AddScreen(navHostController = navController)
        }
        composable(Screen.MainScreen.route) {
            MainScreen(navHostController = navController, viewModel)
        }
        composable(Screen.NoteScreen.route) {
            NoteScreen(navHostController = navController)
        }
    }

}