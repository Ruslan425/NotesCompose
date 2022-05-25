package ru.romazanov.notescompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NoteCard(
    text: String,
    title: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .size(width = 400.dp, height = 100.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        onClick = onClick
    ) {
        Column (
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
                ) {
            Text(
                text = title,
                fontSize = 24.sp
            )
            Text(
                text = text,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                modifier = Modifier.padding(8.dp)
            )
        }

    }
}