package ru.romazanov.notescompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.ui.ButtonDefault

@Composable
fun StartScreen(
    navHostController: NavHostController,
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
            ButtonDefault(onClick = { navHostController.navigate(Screen.MainScreen.route) },
                text = "Местная базаданных")
            ButtonDefault(onClick = { navHostController.navigate(Screen.MainScreen.route) },
                text = "Удаленная базаданных")
        }
    }
}