package uz.mlsoft.dictionaryexamoffline.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun WordItem(data: WordData, onClick: (WordData) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick(data) },
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = data.word,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 20.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp

            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun WordPrev() {
    DictionaryExamOfflineTheme() {
        WordItem(
            data = WordData("hello", "", listOf()),
            onClick = {})
    }
}



