package uz.mlsoft.dictionaryexamoffline.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {
    @Query("SELECT * FROM dictionary_table")
    fun getWordByQuery(): List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllWordsToDatabase(entity: WordEntity)
}