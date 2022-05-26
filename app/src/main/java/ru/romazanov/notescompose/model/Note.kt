package ru.romazanov.notescompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.romazanov.notescompose.utils.Constants.Keys.NOTES_TABLE


@Entity(tableName = NOTES_TABLE)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var subTitle: String
)
