package ru.romazanov.notescompose


import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.romazanov.notescompose.database.room.AppRoomDatabase
import ru.romazanov.notescompose.database.room.repository.RoomRepository
import ru.romazanov.notescompose.model.Note
import ru.romazanov.notescompose.utils.REPOSITORY
import ru.romazanov.notescompose.utils.TYPE_ROOM

class MainVM(application: Application) : ViewModel() {


    private val context = application

    fun initialDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("check Data", "MainViewModel initDatabase type $type")
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }


    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(note = note)
        }
    }


    fun readNotes() = REPOSITORY.readData


    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.update(note = note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(note = note)
        }
    }


}



