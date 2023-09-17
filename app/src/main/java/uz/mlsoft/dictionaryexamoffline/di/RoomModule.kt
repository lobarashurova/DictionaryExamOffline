package uz.mlsoft.dictionaryexamoffline.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.mlsoft.dictionaryexamoffline.data.room.WordDao
import uz.mlsoft.dictionaryexamoffline.data.room.WordDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext context: Context): WordDatabase {
        return Room.databaseBuilder(context, WordDatabase::class.java, "word.db").build()
    }


    @[Singleton Provides]
    fun getDao(database: WordDatabase): WordDao = database.getDao()
}