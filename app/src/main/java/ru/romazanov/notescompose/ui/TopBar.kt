package ru.romazanov.notescompose.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar () {
    TopAppBar(
        title = {
            Text(text = "Заметки")
        },
        backgroundColor = MaterialTheme.colors.primaryVariant ,
        contentColor = Color.White,
        elevation = 14.dp
    )
}