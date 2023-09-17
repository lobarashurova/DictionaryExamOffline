package uz.mlsoft.dictionaryexamoffline.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.mlsoft.dictionaryexamoffline.data.common.WordData
import uz.mlsoft.dictionaryexamoffline.ui.theme.DictionaryExamOfflineTheme

@Composable
fun Searched(data: WordData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "searched word= ${data.word}",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 20.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp

            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "transcription word= ${data.transcription}",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 20.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp

            )

            Spacer(modifier = Modifier.size(10.dp))
            Column {
                data.definition.forEachIndexed { index, data ->
                    Text(
                        text = "definition ${index + 1} -> $data",
                        modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 15.dp), fontSize = 22.sp
                    )
                    Spacer(modifier = Modifier.size(15.dp))
                }
            }


        }

    }

}


@Preview(showBackground = true)
@Composable
fun SearchedPrev() {
    DictionaryExamOfflineTheme() {
        Searched(
            data = WordData("hello", "it is greeting", listOf("me, me , me")),
        )
    }
}