package ru.romazanov.notescompose.screens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import ru.romazanov.notescompose.utils.Constants

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



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            OutlinedTextField(
                value = note.title,
                onValueChange = {
                    note.title = it
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
                value = note.subTitle,
                onValueChange = {
                    note.subTitle = it
                },
                modifier = Modifier.padding(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background,
                    focusedIndicatorColor = Color.Blue.copy(alpha = 0.5f)
                ),
                label = { Text(Constants.Keys.TITLE) }
            )

        }
    }

}