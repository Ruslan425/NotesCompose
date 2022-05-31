package ru.romazanov.notescompose.database.firebase.repository

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import ru.romazanov.notescompose.database.Repository
import ru.romazanov.notescompose.database.firebase.FirebaseNoteList
import ru.romazanov.notescompose.model.Note
import ru.romazanov.notescompose.utils.FIREBASE_ID
import ru.romazanov.notescompose.utils.LOGIN
import ru.romazanov.notescompose.utils.PASSWORD

class FirebaseRepository() : Repository {


    private val loginAuth = FirebaseAuth.getInstance()

    private val database = Firebase.database.reference
        .child(loginAuth.currentUser?.uid.toString())

    override val readData: LiveData<List<Note>>
        get() = FirebaseNoteList()


    override suspend fun create(note: Note) {

        val noteId = database.push().key.toString()
        val mapNotes = hashMapOf<String, Any>()

        mapNotes[FIREBASE_ID] = noteId
        mapNotes["title"] = note.title
        mapNotes["subTitle"] = note.subTitle

        database.child(noteId)
            .updateChildren(mapNotes)

    }

    override suspend fun update(note: Note) {
        val noteId = note.firebaseId
        val mapNotes = hashMapOf<String, Any>()

        mapNotes[FIREBASE_ID] = noteId
        mapNotes["title"] = note.title
        mapNotes["subTitle"] = note.subTitle

        database.child(noteId)
            .updateChildren(mapNotes)
    }

    override suspend fun delete(note: Note) {
        val noteId = note.firebaseId
        database.child(noteId)
            .removeValue()

    }

    override fun singOut() {
        loginAuth.signOut()
    }

    override fun connectToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        loginAuth.signInWithEmailAndPassword(LOGIN, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                loginAuth.createUserWithEmailAndPassword(LOGIN, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onError(it.message.toString()) }
            }
    }
}