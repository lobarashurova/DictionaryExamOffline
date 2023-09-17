package uz.mlsoft.dictionaryexamoffline.data.response.m.baseresponse

data class Phonetic(
    val audio: String,
    val license: License,
    val sourceUrl: String,
    val text: String
)