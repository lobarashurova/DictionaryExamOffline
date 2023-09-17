package uz.mlsoft.dictionaryexamoffline.presentation.home

import uz.mlsoft.dictionaryexamoffline.data.common.WordData
import uz.mlsoft.dictionaryexamoffline.presentation.detail.DetailScreen
import uz.mlsoft.dictionaryexamoffline.utils.navigation.AppNavigator
import javax.inject.Inject

interface HomeDirections {
    suspend fun openDetailScreen(data: WordData)
}

class HomeDirectionsImpl @Inject constructor(private val appNavigator: AppNavigator) : HomeDirections {
    override suspend fun openDetailScreen(data: WordData) {
        appNavigator.openScreenSaveStack(DetailScreen(data))
    }

}