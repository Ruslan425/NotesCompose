package ru.romazanov.notescompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

import androidx.navigation.NavHostController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.ui.ButtonDefault
import ru.romazanov.notescompose.utils.TYPE_FIREBASE
import ru.romazanov.notescompose.utils.TYPE_ROOM

@Composable
fun StartScreen(
    navHostController: NavHostController,
    viewModel: MainVM
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Что будем использовать?",
                fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            ButtonDefault(onClick = {
                viewModel.initialDatabase(TYPE_ROOM)
                viewModel.getList(TYPE_ROOM)
                navHostController.navigate(Screen.MainScreen.route)
                                    },
                text = "Местная базаданных")
            ButtonDefault(onClick = {
                viewModel.initialDatabase(TYPE_FIREBASE)
                viewModel.getList(TYPE_FIREBASE)
                navHostController.navigate(Screen.MainScreen.route) },
                text = "Удаленная базаданных")
        }
    }
}