package ru.romazanov.notescompose.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.romazanov.notescompose.database.room.dao.NoteDao
import ru.romazanov.notescompose.model.Note
import ru.romazanov.notescompose.utils.Constants.Keys.NOTES_DATABASE


@Database(
    version = 1,
    entities = [Note::class],
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getRoomDao(): NoteDao

    companion object {
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    NOTES_DATABASE
                ).build()
                INSTANCE as AppRoomDatabase
            } else INSTANCE as AppRoomDatabase

        }
    }
}