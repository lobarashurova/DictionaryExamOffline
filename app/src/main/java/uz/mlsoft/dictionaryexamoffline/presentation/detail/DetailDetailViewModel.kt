package uz.mlsoft.dictionaryexamoffline.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailDetailViewModel @Inject constructor(
    private val direction: DetailDirections
): DetailContract.ViewModel , ViewModel() {

    override fun onEvenDispatchers(intent: DetailContract.Intent) {
        when(intent) {
            DetailContract.Intent.Back -> {
                viewModelScope.launch {
                    direction.back()
                }
            }
        }
    }
}