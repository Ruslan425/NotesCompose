package ru.romazanov.notescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import ru.romazanov.notescompose.navigation.NavHostControler
import ru.romazanov.notescompose.ui.TopBar
import ru.romazanov.notescompose.ui.theme.NotesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesComposeTheme {
                Scaffold(
                    topBar = {
                        TopBar()
                    })
                {
                    NavHostControler()
                }
            }
        }
    }
}

