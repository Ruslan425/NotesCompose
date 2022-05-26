package ru.romazanov.notescompose.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.romazanov.notescompose.model.Note
import ru.romazanov.notescompose.utils.Constants.Keys.NOTES_TABLE


@Dao
interface NoteDao {

    @Query("SELECT * FROM $NOTES_TABLE")
    fun getNoteList(): LiveData<List<Note>>

    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}