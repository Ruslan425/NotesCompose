package ru.romazanov.notescompose.utils

import ru.romazanov.notescompose.database.Repository

const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val FIREBASE_ID = "firebaseId"


lateinit var REPOSITORY: Repository
lateinit var LOGIN: String
lateinit var PASSWORD: String
lateinit var TYPE_DB: String

class Constants {
    object Keys {
        const val NOTES_TABLE = "notes_table"
        const val NOTES_DATABASE = "notes_database"
        const val TITLE = "Заголовок"
        const val NOTE = "Заметка"
        const val START_SCREEN_QUESTION = "Что будем использовать?"
        const val ROOM_DATABASE = "Местная базаданных"
        const val FIREBASE_DATABASE = "Удаленная базаданных"
        const val ID = "Id"
        const val UPDATE_NOTE = "Редактировать"
    }

    object Screens {
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val ADD_SCREEN = "add_screen"
        const val NOTE_SCREEN = "note_screen"

    }
}