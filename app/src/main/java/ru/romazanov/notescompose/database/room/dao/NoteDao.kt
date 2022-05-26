package ru.romazanov.notescompose.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.romazanov.notescompose.model.Note


@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table")
    fun getNoteList(): LiveData<List<Note>>

    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}