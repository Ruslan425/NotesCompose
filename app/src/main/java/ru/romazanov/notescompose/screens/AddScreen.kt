package ru.romazanov.notescompose.screens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.model.Note
import ru.romazanov.notescompose.navigation.Screen
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun AddScreen(
    navHostController: NavHostController,
    viewModel: MainVM
) {
    var title by remember { mutableStateOf("") }

    var subTitle by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                content = {
                    Icon(Icons.Filled.Add, contentDescription = null)
                },
                onClick = {
                    focusManager.clearFocus()
                    viewModel.addNote(
                        Note(
                            title = title,
                            subTitle = subTitle
                        )
                    )
                    navHostController.navigate(Screen.MainScreen.route)

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
                Text(text = "Заголовок",
                    modifier = Modifier
                        .padding(top = 24.dp, start = 24.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.h5
                )

                BasicTextField(
                    value = title,
                    onValueChange = {
                        title = it
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

                Text(text = "Заметка",
                    modifier = Modifier
                        .padding(top = 24.dp, start = 24.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.body1
                )

                BasicTextField(
                    value = subTitle,
                    onValueChange = {
                        subTitle = it

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