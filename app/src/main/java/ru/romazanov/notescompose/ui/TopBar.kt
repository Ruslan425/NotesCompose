package ru.romazanov.notescompose.ui

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar () {
    TopAppBar(
        title = {
            Text(text = "Notes")
        },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 14.dp
    )
}