package uz.mlsoft.dictionaryexamoffline.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.mlsoft.dictionaryexamoffline.presentation.detail.DetailDirections
import uz.mlsoft.dictionaryexamoffline.presentation.detail.DetailDirectionsImpl
import uz.mlsoft.dictionaryexamoffline.presentation.home.HomeDirections
import uz.mlsoft.dictionaryexamoffline.presentation.home.HomeDirectionsImpl


@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindMainDirection(impl: HomeDirectionsImpl): HomeDirections

    @Binds
    fun bindAddDirection(impl: DetailDirectionsImpl): DetailDirections

}

