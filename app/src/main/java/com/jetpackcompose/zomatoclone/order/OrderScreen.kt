package com.jetpackcompose.zomatoclone.order

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.components.*
import com.jetpackcompose.zomatoclone.home.*

@Composable
fun OrderScreen(
        uiState: HomePresenter.HomePageUiState,
        onFilterItemTapped: (HomePresenter.Section)->Unit
) {
    when(uiState){
        is HomePresenter.HomePageUiState.Loading ->{

        }
        is HomePresenter.HomePageUiState.Error ->{

        }
        is HomePresenter.HomePageUiState.Success ->{
            val filters =  uiState.items[HomePresenter.SectionType.Filter] as List<HomePresenter.Section.Filter>
            val categories =  uiState.items[HomePresenter.SectionType.Category] as List<HomePresenter.Section.Category>
            val cuisines =  uiState.items[HomePresenter.SectionType.Cuisine] as List<HomePresenter.Section.Cuisine>
            val restaurants =  uiState.items[HomePresenter.SectionType.Restaurant] as List<HomePresenter.Section.Restaurants>
            val cuisineUiState = mutableStateOf(CusineListUiState(cuisines, false))

            ScrollableColumn(modifier = Modifier.padding(15.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    LocationView(Modifier.weight(4f))
                    QRCodeScannerView(Modifier.weight(0.5f))
                }
                SearchView(Modifier.padding(vertical = 20.dp))
                FilterComponent(Modifier.padding(vertical = 1.dp), filters) { item -> onFilterItemTapped(item) }
                CategoryComponent(modifier = Modifier.padding(vertical = 20.dp), items = categories, onItemClick = {
                })
                CuisineComponent(modifier = Modifier.padding(vertical = 15.dp), cuisineListUiState = cuisineUiState, onItemClick = {
                }, showMoreUiState = getShowMoreUiState(cuisineUiState))
                RestaurantComponent(modifier = Modifier.padding(vertical = 15.dp), restaurants, onItemClick = {

                })
            }
        }
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


