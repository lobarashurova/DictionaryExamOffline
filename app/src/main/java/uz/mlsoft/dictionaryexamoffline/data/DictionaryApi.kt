package uz.mlsoft.dictionaryexamoffline.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import uz.mlsoft.dictionaryexamoffline.data.common.WordData
import uz.mlsoft.dictionaryexamoffline.data.response.m.baseresponse.WordResult
import uz.mlsoft.dictionaryexamoffline.data.response.m.baseresponse.WordResultItem

interface DictionaryApi {
    @GET("en/{query}")
    suspend fun getWordById (@Path("query") query: String): Response<WordResult>
}