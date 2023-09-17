package uz.mlsoft.dictionaryexamoffline.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.mlsoft.dictionaryexamoffline.data.common.WordData
import uz.mlsoft.dictionaryexamoffline.domain.DictionaryRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val directions: HomeDirections,
    private val repository: DictionaryRepository
) : HomeContract.HomeViewModel, ViewModel() {
    override val uiState = MutableStateFlow<HomeContract.UiState>(
        HomeContract.UiState(listOf(), WordData("", "", listOf()))
    )

    private fun reduce(block: HomeContract.UiState.() -> HomeContract.UiState) {
        val oldValue = uiState.value
        val newValue = block(oldValue)
        viewModelScope.launch {
            uiState.emit(newValue)
        }
//        uiState.tryEmit(newValue)
    }

    init {
        viewModelScope.launch {
            val list = repository.getWordsFromDatabase()
            reduce { this.copy(list = list) }
        }
    }


    override fun onEventDispatcher(intent: HomeContract.Intent) {
        when (intent) {
            is HomeContract.Intent.searchClickes -> {
                repository.getWordsByEthernet(intent.word)
                    .onEach {
                        it.onSuccess {
                            reduce { this.copy(data = it) }
                            val list = repository.getWordsFromDatabase()
                            reduce { this.copy(list = list) }
                        }
                        it.onFailure {

                        }
                    }
                    .launchIn(viewModelScope)


            }

            is HomeContract.Intent.onClick -> {
                viewModelScope.launch {
                    directions.openDetailScreen(intent.data)
                }
            }

        }
    }
}