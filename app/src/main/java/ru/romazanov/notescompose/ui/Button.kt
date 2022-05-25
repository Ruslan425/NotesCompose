package ru.romazanov.notescompose.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonDefault(
    onClick:() -> Unit,
    text: String,
) {
    Button(
        onClick = onClick ,
        modifier = Modifier
            .width(200.dp)
            .padding(vertical = 8.dp)
    ) {
      Text(text = text)
    }

}