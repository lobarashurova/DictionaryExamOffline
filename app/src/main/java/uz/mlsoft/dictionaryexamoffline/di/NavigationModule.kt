package uz.mlsoft.dictionaryexamoffline.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.mlsoft.dictionaryexamoffline.utils.navigation.AppNavigator
import uz.mlsoft.dictionaryexamoffline.utils.navigation.NavigationDispatcher
import uz.mlsoft.dictionaryexamoffline.utils.navigation.NavigationHandler


@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindAppNavigator(impl: NavigationDispatcher): AppNavigator

    @Binds
    fun bindNavigationHandler(impl: NavigationDispatcher): NavigationHandler
}