package uz.mlsoft.dictionaryexamoffline.presentation.detail

import uz.mlsoft.dictionaryexamoffline.utils.navigation.AppNavigator
import javax.inject.Inject


interface DetailDirections {
    suspend fun back()
}

class DetailDirectionsImpl @Inject constructor(val appNavigator: AppNavigator) : DetailDirections {
    override suspend fun back() {
        appNavigator.back()
    }

}