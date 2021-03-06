package ru.romazanov.notescompose.screens


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.model.Note
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalFocusManager
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.utils.TYPE_DB
import ru.romazanov.notescompose.utils.TYPE_FIREBASE
import ru.romazanov.notescompose.utils.TYPE_ROOM


@Composable
fun NoteScreen(
    navHostController: NavHostController,
    viewModel: MainVM,
    noteId: String?
) {
    val list = viewModel.readNotes().observeAsState(initial = listOf()).value





    val note = when(TYPE_DB) {
        TYPE_ROOM -> {
            list.firstOrNull { it.id == noteId?.toInt() } ?: Note()
        }

        TYPE_FIREBASE -> {
            list.firstOrNull{ it.firebaseId == noteId } ?: Note()
        }
        else -> Note()
    }

    val focusManager = LocalFocusManager.current

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
                    focusManager.clearFocus()
                    navHostController.navigate(Screen.MainScreen.route)
                }) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "??????????????????")
                }
                Spacer(Modifier.weight(1f, true))

                IconButton(onClick = {
                    focusManager.clearFocus()
                    viewModel.deleteNote(note)
                    navHostController.navigate(Screen.MainScreen.route)

                }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "??????????????")
                }
            }
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {

                Text(text = "??????????????????",
                    modifier = Modifier
                        .padding(top = 24.dp, start = 24.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.h5
                )

                BasicTextField(
                    value = title,
                    onValueChange = {
                        title = it
                        viewModel.updateNote(
                            Note(
                                id = note.id,
                                title = title,
                                subTitle = subTitle,
                                firebaseId = note.firebaseId
                            )
                        )
                    },
                    modifier = Modifier
                        .padding(top = 24.dp, start = 24.dp)
                        .fillMaxWidth(),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.h5
                )
                Canvas(modifier = Modifier.fillMaxWidth()
                    .padding(top = 4.dp)) {
                    drawLine(
                        color = Color(0xFF2196F3),
                        start = Offset(x = 60f, y = 0f),
                        end = Offset(x = 1020f, y = 0f),
                        strokeWidth = 5F,
                        cap = StrokeCap.Round
                    )
                }

                Text(text = "??????????????",
                    modifier = Modifier
                        .padding(top = 24.dp, start = 24.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.body1
                )
                BasicTextField(
                    value = subTitle,
                    onValueChange = {
                        subTitle = it
                        viewModel.updateNote(
                            Note(
                                id = note.id,
                                title = title,
                                subTitle = subTitle,
                                firebaseId = note.firebaseId
                            )
                        )
                    },
                    modifier = Modifier
                        .padding(top = 24.dp, start = 24.dp)
                        .fillMaxWidth(),
                    textStyle = MaterialTheme.typography.body1,
                )

            }
        }
    }

}