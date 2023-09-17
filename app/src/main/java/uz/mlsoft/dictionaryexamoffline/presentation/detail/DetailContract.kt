package uz.mlsoft.dictionaryexamoffline.presentation.detail

interface DetailContract {
    interface ViewModel {
        fun onEvenDispatchers(intent : Intent)
    }

    interface Intent {
        object Back : Intent
    }
}