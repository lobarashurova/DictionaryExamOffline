package uz.mlsoft.dictionaryexamoffline.data.response.m.baseresponse

data class WordResultItem(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String
)