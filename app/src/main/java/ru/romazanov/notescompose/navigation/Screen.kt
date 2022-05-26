package ru.romazanov.notescompose.navigation

import ru.romazanov.notescompose.utils.Constants

sealed class Screen(val route: String){
    object StartScreen: Screen(Constants.Screens.START_SCREEN)
    object MainScreen: Screen(Constants.Screens.MAIN_SCREEN)
    object NoteScreen: Screen(Constants.Screens.NOTE_SCREEN)
    object AddScreen: Screen(Constants.Screens.ADD_SCREEN)
}
