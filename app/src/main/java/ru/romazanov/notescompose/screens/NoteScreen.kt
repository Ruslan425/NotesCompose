package ru.romazanov.notescompose.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.model.Note
import androidx.compose.material.TopAppBar
import ru.romazanov.notescompose.utils.Constants
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.utils.Constants.Keys.NOTE
import ru.romazanov.notescompose.utils.Constants.Keys.TITLE
import ru.romazanov.notescompose.utils.Constants.Keys.UPDATE_NOTE


@Composable
fun NoteScreen(
    navHostController: NavHostController,
    viewModel: MainVM,
    noteId: String?
) {
    val list = viewModel.readNotes().observeAsState(initial = listOf()).value

    var note = list.firstOrNull { it.id == noteId?.toInt() } ?: Note(
        id = 0,
        title = "NONE",
        subTitle = "ERROR"
    )

    var title by remember { mutableStateOf("") }

    var subTitle by remember { mutableStateOf("") }

    subTitle = note.subTitle
    title = note.title

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = Color.White,
                elevation = 16.dp,
            ) {
                IconButton(onClick = {
                    viewModel.updateNote(note) {
                        viewModel.updateNote(
                            Note(
                                id = note.id,
                                title = title,
                                subTitle = subTitle
                            )
                        ) {
                            navHostController.navigate(Screen.MainScreen.route)
                        }
                    }
                }) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "Сохранить")
                }
                Spacer(Modifier.weight(1f, true))

                IconButton(onClick = {
                    viewModel.deleteNote(note) {
                        navHostController.navigate(Screen.MainScreen.route)
                    }
                }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Удалить")
                }
            }
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
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
                    label = { Text(TITLE) },
                )
                OutlinedTextField(
                    value = subTitle,
                    onValueChange = {
                        subTitle = it
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background,
                        focusedIndicatorColor = Color.Blue.copy(alpha = 0.5f)
                    ),
                    label = { Text(NOTE) },
                )

            }
        }
    }

}