package ru.romazanov.notescompose.screens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.model.Note
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.utils.Constants

@Composable
fun AddScreen(
    navHostController: NavHostController,
    viewModel: MainVM
) {
    var title by remember { mutableStateOf("") }

    var text by remember{ mutableStateOf("") }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                content = {
                    Icon(Icons.Filled.Add, contentDescription = null)
                },
                onClick = {
                    viewModel.addNote(
                        Note(
                            title = title,
                            subTitle = text
                        )
                    ) {
                        navHostController.navigate(Screen.MainScreen.route)
                    }
                }
            )
        },
        isFloatingActionButtonDocked = true,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background,
                        focusedIndicatorColor = Color.Blue.copy(alpha = 0.5f)
                    ),
                    singleLine = true,
                    label = { Text(Constants.Keys.NOTE) }
                )
                OutlinedTextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background,
                        focusedIndicatorColor = Color.Blue.copy(alpha = 0.5f)
                    ),
                    label = { Text(Constants.Keys.TITLE)},
                )
            }
        }
    }
}