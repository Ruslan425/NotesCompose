package ru.romazanov.notescompose.navigation

sealed class Screen(val route: String){
    object Start: Screen("start")
    object Main: Screen("main")
    object Note: Screen("note")
    object Add: Screen("add_note")
}
