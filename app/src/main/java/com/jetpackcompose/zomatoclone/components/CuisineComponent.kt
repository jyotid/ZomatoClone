package com.jetpackcompose.zomatoclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.zomatoclone.home.Cuisine
import com.jetpackcompose.zomatoclone.home.ShowMoreUiState

@Composable
fun CuisineComponent(modifier: Modifier,
                     items: List<Cuisine>,
                     onItemClick: (Cuisine) -> Unit,
                     showMoreUiState: ShowMoreUiState
) {
    Column(modifier = modifier) {
        Text(text = "Eat what makes you happy", fontWeight = FontWeight.Bold)
        LazyGridFor(items = items, rows = 3) { cuisine: Cuisine, modifier: Modifier ->
            getCuisineCard(modifier, cuisine, onItemClick = onItemClick)
        }
        Card(Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable(onClick = { showMoreUiState.onClick() })) {
            Text(text = showMoreUiState.label, textAlign = TextAlign.Center, modifier = Modifier.padding(4.dp))
        }
    }

}

@Composable
fun getCuisineCard(modifier: Modifier, cuisine: Cuisine, onItemClick: (Cuisine) -> Unit) {
    Card(modifier = modifier.padding(5.dp), elevation = 8.dp) {
        Column(modifier = Modifier.clickable(onClick = { onItemClick(cuisine) })) {
            Image(contentScale = ContentScale.FillWidth, asset = imageResource(id = cuisine.drawableRes), modifier = Modifier.weight(2.0f).fillMaxWidth())
            Text(textAlign = TextAlign.Center, text = cuisine.label, fontSize = 12.sp, modifier = Modifier.weight(1.0f).fillMaxWidth().padding(vertical = 5.dp))
        }
    }
}

@Composable
fun <T> LazyGridFor(
        items: List<T> = listOf(),
        rows: Int,
        itemContent: @Composable LazyItemScope.(T, Modifier) -> Unit
) {
    val chunkedList = items.chunked(rows)
    LazyColumnFor(items = chunkedList) {
        Row {
            it.forEach { item ->
                itemContent(item, Modifier.weight(1.0f).height(120.dp))
            }
            repeat(rows - it.size) {
                Box(modifier = Modifier.weight(1F).padding(8.dp)) {}
            }
        }
    }
}
