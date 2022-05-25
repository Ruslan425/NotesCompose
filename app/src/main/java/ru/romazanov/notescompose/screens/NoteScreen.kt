package ru.romazanov.notescompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun NoteScreen(
    navHostController: NavHostController
) {
    var title by rememberSaveable { mutableStateOf("Заголовок") }

    var text by rememberSaveable { mutableStateOf("тест ".repeat(300))}



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
                    focusedIndicatorColor = Color.Blue.copy(alpha = 0.5f)),
                singleLine = true
            )
            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier.padding(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background,
                    focusedIndicatorColor = Color.Blue.copy(alpha = 0.5f))
            )
        }
    }

}