package uz.mlsoft.dictionaryexamoffline.data.common

data class WordData(
    val word: String,
    val transcription: String,
    val definition: List<String>
)