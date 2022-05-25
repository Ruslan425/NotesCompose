package ru.romazanov.notescompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.model.Note
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.ui.NoteCard

@Composable
fun MainScreen(
    navHostController: NavHostController,
    viewModel: MainVM
) {

  val list by remember { mutableStateOf(viewModel.readTest.value) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                content = {
                     Icon(Icons.Filled.Add, contentDescription = "Добавить")},
                onClick = {
                    navHostController.navigate(Screen.AddScreen.route)
                }
            )
        },
        isFloatingActionButtonDocked = true,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp)
        ){
            items(list!!) { item ->
                NoteCard(
                    text = item.subTitle,
                    title = item.title,
                    onClick = { navHostController.navigate(Screen.NoteScreen.route) }
                )
            }
        }
    }

}