package ru.romazanov.notescompose.database.room.repository

import androidx.lifecycle.LiveData
import ru.romazanov.notescompose.database.Repository
import ru.romazanov.notescompose.database.room.dao.NoteDao
import ru.romazanov.notescompose.model.Note

class RoomRepository(
    private val noteDao: NoteDao,
) : Repository {

    override val readData: LiveData<List<Note>>
        get() = noteDao.getNoteList()


    override suspend fun create(note: Note) {
        noteDao.addNote(note)
    }

    override suspend fun update(note: Note) {
        noteDao.updateNote(note)
    }

    override suspend fun delete(note: Note) {
        noteDao.deleteNote(note)
    }
}