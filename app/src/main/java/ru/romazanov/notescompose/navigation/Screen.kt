package ru.romazanov.notescompose.navigation

sealed class Screen(val route: String){
    object StartScreen: Screen("start_screen")
    object MainScreen: Screen("main_screen")
    object NoteScreen: Screen("note_screen")
    object AddScreen: Screen("add_note_screen")
}
