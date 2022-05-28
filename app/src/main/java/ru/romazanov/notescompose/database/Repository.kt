package ru.romazanov.notescompose.database

import androidx.lifecycle.LiveData
import ru.romazanov.notescompose.model.Note

interface Repository {

    val readData : LiveData<List<Note>>


    suspend fun create(note: Note)

    suspend fun update(note: Note)

    suspend fun delete(note: Note)

}