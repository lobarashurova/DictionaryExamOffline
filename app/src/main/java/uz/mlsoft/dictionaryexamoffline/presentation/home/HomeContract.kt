package uz.mlsoft.dictionaryexamoffline.presentation.home

import kotlinx.coroutines.flow.StateFlow
import uz.mlsoft.dictionaryexamoffline.data.common.WordData

interface HomeContract {
    interface HomeViewModel{
        val uiState:StateFlow<HomeContract.UiState>
        fun onEventDispatcher(intent:Intent)
    }

    data class UiState(
        val list: List<WordData>,
        val data: WordData

    )

    interface Intent{
        data class onClick(val data: WordData):Intent
        data class searchClickes(val word:String):Intent
    }
}