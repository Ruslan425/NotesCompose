package ru.romazanov.notescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.romazanov.notescompose.screens.Add
import ru.romazanov.notescompose.screens.Main
import ru.romazanov.notescompose.screens.Note
import ru.romazanov.notescompose.screens.Start


@Composable
fun NavHostControler(

) {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Start.route) {

        composable(Screen.Start.route) {
           Start(navHostController = navController)
        }
        composable(Screen.Add.route) {
            Add(navHostController = navController)
        }
        composable(Screen.Main.route) {
           Main(navHostController = navController)
        }
        composable(Screen.Note.route) {
            Note(navHostController = navController)
        }
    }

}