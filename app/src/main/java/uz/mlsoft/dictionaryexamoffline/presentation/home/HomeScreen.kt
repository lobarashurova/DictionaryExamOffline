package uz.mlsoft.dictionaryexamoffline.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.mlsoft.dictionaryexamoffline.R
import uz.mlsoft.dictionaryexamoffline.data.common.WordData
import uz.mlsoft.dictionaryexamoffline.ui.theme.DictionaryExamOfflineTheme
import uz.mlsoft.dictionaryexamoffline.ui.theme.components.Searched
import uz.mlsoft.dictionaryexamoffline.ui.theme.components.WordItem
import uz.mlsoft.dictionaryexamoffline.utils.myLog

class HomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: HomeContract.HomeViewModel = getViewModel<HomeViewModel>()
        HomeContent(
            uiState = viewModel.uiState.collectAsState(),
            onEventDispatcher = viewModel::onEventDispatcher,
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    uiState: State<HomeContract.UiState>,
    onEventDispatcher: (HomeContract.Intent) -> Unit,
) {
    var query: String by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(content = {
            item {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .padding(start = 40.dp)
                            .padding(vertical = 20.dp)
                    ) {
                        TextField(
                            value = query,
                            onValueChange = { query = it },
                            modifier = Modifier
                                .height(105.dp)

                        )
                    }
                    Image(painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                myLog("clicked")
                                onEventDispatcher.invoke(
                                    HomeContract.Intent.searchClickes(query)
                                )
                            })
                }


            }

            item {
                Searched(data = uiState.value.data)
            }

            items(uiState.value.list) {
                WordItem(
                    data = it,
                    onClick = { onEventDispatcher.invoke(HomeContract.Intent.onClick(it)) })
            }
        })


    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun HomePrev() {
    DictionaryExamOfflineTheme {
        HomeContent(
            mutableStateOf(HomeContract.UiState(listOf(), WordData("hello", "hello", listOf()))),
            {},
        )
    }
}
