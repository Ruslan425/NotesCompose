package ru.romazanov.notescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.screens.AddScreen
import ru.romazanov.notescompose.screens.MainScreen
import ru.romazanov.notescompose.screens.NoteScreen
import ru.romazanov.notescompose.screens.StartScreen
import ru.romazanov.notescompose.utils.Constants


@Composable
fun NavHostControler(
    viewModel: MainVM,
    navController: NavHostController
) {


    NavHost(navController = navController, startDestination = Screen.StartScreen.route) {

        composable(Screen.StartScreen.route) {
            StartScreen(navHostController = navController, viewModel)
        }
        composable(Screen.AddScreen.route) {
            AddScreen(navHostController = navController, viewModel)
        }
        composable(Screen.MainScreen.route) {
            MainScreen(navHostController = navController, viewModel)
        }
        composable(Screen.NoteScreen.route + "/{${Constants.Keys.ID}}") { entry ->
            NoteScreen(navHostController = navController, viewModel,
                noteId = entry.arguments?.getString(Constants.Keys.ID)
            )
        }
    }

}