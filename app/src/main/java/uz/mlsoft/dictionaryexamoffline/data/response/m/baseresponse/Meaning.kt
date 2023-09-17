package uz.mlsoft.dictionaryexamoffline.data.response.m.baseresponse

data class Meaning(
    val antonyms: List<String>,
    val definitions: List<Definition>,
    val partOfSpeech: String,
    val synonyms: List<String>
)