package ru.romazanov.notescompose

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.romazanov.notescompose.model.Note
import ru.romazanov.notescompose.utils.TYPE_ROOM
import kotlin.random.Random

class MainVM : ViewModel() {

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }


    init {
        readTest.value =
            when (dbType.value) {
                TYPE_ROOM -> {
                    List(10){
                        Note(
                            id = Random.nextInt(),
                            title = "Заголовок",
                            subTitle = "Текс".repeat(100)
                        )
                    }
                }
                else -> {
                    List(10){
                        Note(
                            id = Random.nextInt(),
                            title = "Заголовок",
                            subTitle = "Текс".repeat(100)
                        )
                    }
                }
            }
        }

    fun initialDatabase(type: String) {

        dbType.value = type
        Log.d("check Data", "MainViewModel initDatabase")
    }
}



