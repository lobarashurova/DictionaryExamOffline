package uz.mlsoft.dictionaryexamoffline.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dictionary_table")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val word: String,
    val transcription: String,
    val definition: String
)