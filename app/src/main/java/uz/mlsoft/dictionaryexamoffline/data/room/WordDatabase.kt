package uz.mlsoft.dictionaryexamoffline.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordDatabase :RoomDatabase(){
    abstract fun getDao():WordDao
}