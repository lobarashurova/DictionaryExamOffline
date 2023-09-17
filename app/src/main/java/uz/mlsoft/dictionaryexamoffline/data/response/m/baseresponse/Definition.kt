package uz.mlsoft.dictionaryexamoffline.data.response.m.baseresponse

data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms:List<Any>

)