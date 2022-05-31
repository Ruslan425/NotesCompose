package ru.romazanov.notescompose.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import ru.romazanov.notescompose.model.Note

class FirebaseNoteList: LiveData<List<Note>>() {

    private val loginAuth = FirebaseAuth.getInstance()
    private val database = Firebase.database.reference
        .child(loginAuth.currentUser?.uid.toString())


    private val listener = object: ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val notes = mutableListOf<Note>()

            snapshot.children.map {
                notes.add(it.getValue(Note::class.java)?: Note())
            }
            value = notes
        }

        override fun onCancelled(error: DatabaseError) {

        }

    }

    override fun onActive() {
        database.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        database.removeEventListener(listener)
        super.onInactive()
    }
}