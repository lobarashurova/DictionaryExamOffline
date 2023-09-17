package uz.mlsoft.dictionaryexamoffline.domain

import kotlinx.coroutines.flow.Flow
import uz.mlsoft.dictionaryexamoffline.data.common.WordData

interface DictionaryRepository {
     fun getWordsByEthernet(query: String): Flow<Result<WordData>>
    suspend fun getWordsFromDatabase(): List<WordData>
}