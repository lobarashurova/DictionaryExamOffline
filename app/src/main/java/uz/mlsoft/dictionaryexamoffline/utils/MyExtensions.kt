package uz.mlsoft.dictionaryexamoffline.utils

import android.util.Log
import uz.mlsoft.dictionaryexamoffline.data.common.WordData
import uz.mlsoft.dictionaryexamoffline.data.response.m.baseresponse.WordResultItem
import uz.mlsoft.dictionaryexamoffline.data.room.WordEntity

//
//fun WordResultItem.toData():WordData{
//    return WordData(this.word,this.meanings)
//}

fun myLog(message: String) {
    Log.d("TTT", message)
}


fun WordResultItem.toCommonData(list: List<String>): WordData =
    WordData(this.word, this.phonetic, list)

fun WordResultItem.toEntityData(definition: String): WordEntity =
    WordEntity(0, this.word, definition, this.phonetic)

fun WordEntity.toCommonData(): WordData =
    WordData(this.word,  this.transcription, this.definition.split("#"),)

