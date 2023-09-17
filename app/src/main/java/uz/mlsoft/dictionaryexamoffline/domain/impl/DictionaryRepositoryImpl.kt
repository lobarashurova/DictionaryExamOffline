package uz.mlsoft.dictionaryexamoffline.domain.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import uz.mlsoft.dictionaryexamoffline.data.DictionaryApi
import uz.mlsoft.dictionaryexamoffline.data.common.WordData
import uz.mlsoft.dictionaryexamoffline.data.room.WordDao
import uz.mlsoft.dictionaryexamoffline.domain.DictionaryRepository
import uz.mlsoft.dictionaryexamoffline.utils.toCommonData
import uz.mlsoft.dictionaryexamoffline.utils.toEntityData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DictionaryRepositoryImpl
@Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val dictionaryDao: WordDao
) : DictionaryRepository {
    private val gson = Gson()
    override fun getWordsByEthernet(query: String): Flow<Result<WordData>> = flow {
        val response = dictionaryApi.getWordById(query)
        if (response.isSuccessful && response.body() != null) {
            val list = ArrayList<String>()
            val sb = StringBuilder()
            response.body()!!.map {
                it.meanings[0].definitions.forEach {
                    sb.append("${it.definition}/")
                    list.add(it.definition)
                }
            }
            dictionaryDao.addAllWordsToDatabase(response.body()!![0].toEntityData(sb.toString()))
            emit(Result.success(response.body()!![0].toCommonData(list)))
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string())))
        }
    }
        .catch { emit(Result.failure(Exception(it))) }
        .flowOn(Dispatchers.IO)


    override suspend fun getWordsFromDatabase(): List<WordData> = withContext(Dispatchers.IO) {
         dictionaryDao.getWordByQuery().map { it.toCommonData() }
    }

}