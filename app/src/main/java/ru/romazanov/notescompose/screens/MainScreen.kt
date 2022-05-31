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
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.ui.NoteCard
import ru.romazanov.notescompose.utils.TYPE_DB
import ru.romazanov.notescompose.utils.TYPE_FIREBASE
import ru.romazanov.notescompose.utils.TYPE_ROOM

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
                val noteId = when(TYPE_DB) {
                    TYPE_ROOM -> note.id
                    TYPE_FIREBASE -> note.firebaseId
                    else -> "EMPTY"
                }
                NoteCard(
                    subTitle = note.subTitle,
                    title = note.title,
                    onClick = {
                        println(noteId)
                        navHostController.navigate(Screen.NoteScreen.route + "/${noteId}")
                    }
                )
            }
        }

    }

}
