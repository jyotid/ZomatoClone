package com.jetpackcompose.zomatoclone.order

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.components.*
import com.jetpackcompose.zomatoclone.home.*

@Composable
fun OrderScreen() {
    val filterItems = mutableStateListOf(
            FilterItem(1, "Filter", R.drawable.ic_filter),
            FilterItem(2, "Bookmarks", R.drawable.ic_bookmark),
            FilterItem(1, "Rating: 4.0+", null),
            FilterItem(2, "Safe and hygenice", null)
    )
    val categoryItem = listOf(
            Category(1, "Pure Veg", R.drawable.ic_veg),
            Category(2, "Max Safety", R.drawable.ic_safety),
            Category(1, "Pro", R.drawable.ic_pro),
            Category(1, "Trending", R.drawable.ic_trending)

    )
    val cuisine = mutableStateListOf<Cuisine>(
            Cuisine(1, "Pasta", R.drawable.pasta),
            Cuisine(1, "Salad", R.drawable.salad),
            Cuisine(1, "french", R.drawable.french),
            Cuisine(1, "Pasta", R.drawable.pasta),
            Cuisine(1, "Salad", R.drawable.salad),
            Cuisine(1, "french", R.drawable.french),
            Cuisine(1, "Pasta", R.drawable.pasta),
            Cuisine(1, "Salad", R.drawable.salad),
            Cuisine(1, "french", R.drawable.french),
            Cuisine(1, "Pasta", R.drawable.pasta),
            Cuisine(1, "Salad", R.drawable.salad),
            Cuisine(1, "french", R.drawable.french)
    )
    val cuisineUiState = mutableStateOf(CusineListUiState(cuisine, false))


    ScrollableColumn(modifier = Modifier.padding(15.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                LocationView(Modifier.weight(4f))
                QRCodeScannerView(Modifier.weight(0.5f))
            }
            SearchView(Modifier.padding(vertical = 20.dp))
            FilterComponent(Modifier.padding(vertical = 1.dp), filterItems) { item ->
                val index = filterItems.indexOf(item)
                val modifiedItem = item.copy(isSelected = !item.isSelected)
                filterItems.removeAt(index)
                filterItems.add(index, modifiedItem)
            }
            CategoryComponent(modifier = Modifier.padding(vertical = 20.dp), items = categoryItem, onItemClick = {
            })
            CuisineComponent(modifier = Modifier.padding(vertical = 15.dp), cuisineListUiState = cuisineUiState, onItemClick = {
            }, showMoreUiState = getShowMoreUiState(cuisineUiState))
        }
}

fun getShowMoreUiState(cuisineUiState: MutableState<CusineListUiState>): ShowMoreUiState {
    val isExpanded = cuisineUiState.value.isExpanded
    return ShowMoreUiState(
            label = if (isExpanded) "see less" else "see more",
            drawableRes = if (isExpanded) R.drawable.ic_collapse else R.drawable.ic_expand
    ) {
        cuisineUiState.value = cuisineUiState.value.copy(isExpanded = !isExpanded)
    }
}


