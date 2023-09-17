package uz.mlsoft.dictionaryexamoffline.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.mlsoft.dictionaryexamoffline.domain.DictionaryRepository
import uz.mlsoft.dictionaryexamoffline.domain.impl.DictionaryRepositoryImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @[Binds Singleton]
    fun provideRepository(impl: DictionaryRepositoryImpl): DictionaryRepository
}