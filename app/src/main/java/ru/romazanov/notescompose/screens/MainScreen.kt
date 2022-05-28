package ru.romazanov.notescompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.ui.NoteCard

@Composable
fun MainScreen(
    navHostController: NavHostController,
    viewModel: MainVM
) {
    val list = viewModel.readNotes().observeAsState(initial = listOf()).value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                content = {
                    Icon(Icons.Filled.Add, contentDescription = null)
                },
                onClick = {
                    navHostController.navigate(Screen.AddScreen.route)
                }
            )
        },
        isFloatingActionButtonDocked = true,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(list) { note ->
                NoteCard(
                    text = note.subTitle,
                    title = note.title,
                    onClick = {
                        println(note.id)
                        navHostController.navigate(Screen.NoteScreen.route + "/${note.id}")
                    }
                )
            }
        }

    }

}
