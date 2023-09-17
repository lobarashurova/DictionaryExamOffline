package uz.mlsoft.dictionaryexamoffline.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.mlsoft.dictionaryexamoffline.R
import uz.mlsoft.dictionaryexamoffline.data.common.WordData
import uz.mlsoft.dictionaryexamoffline.ui.theme.DictionaryExamOfflineTheme
import uz.mlsoft.dictionaryexamoffline.ui.theme.components.Searched

class DetailScreen(val data: WordData) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: DetailContract.ViewModel = getViewModel<DetailDetailViewModel>()

        DetailContent(data = data, viewModel::onEvenDispatchers)
    }

}

@Composable
fun DetailContent(data: WordData, onEventDispatcher: (DetailContract.Intent) -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "",
                modifier = Modifier
                    .size(75.dp)
                    .padding(20.dp)
                    .clickable { onEventDispatcher.invoke(DetailContract.Intent.Back) }
            )

            Searched(data = data)


        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailContentPrev() {
    DictionaryExamOfflineTheme {
        DetailContent(WordData("hello", "hello", listOf()), {})
    }
}
