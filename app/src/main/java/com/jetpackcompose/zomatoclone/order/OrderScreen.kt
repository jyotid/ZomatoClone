package com.jetpackcompose.zomatoclone.order

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.components.*
import com.jetpackcompose.zomatoclone.home.*
import com.jetpackcompose.zomatoclone.home.HomePresenter.SectionNew.*

@Composable
fun OrderScreen(
        uiState: HomePresenter.HomePageUiState,
        onFilterItemTapped: (HomePresenter.Item)->Unit,
        onShowMoreClick : () -> Unit
) = when(uiState){
    is HomePresenter.HomePageUiState.Loading ->{

    }
    is HomePresenter.HomePageUiState.Error ->{

    }
    is HomePresenter.HomePageUiState.Success ->{
        val filters =  uiState.items[HomePresenter.SectionType.FilterSection] as FilterSection
        val restaurants =  uiState.items[HomePresenter.SectionType.RestaurantSection] as RestaurantSection

        ScrollableColumn(modifier = Modifier.padding(15.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                LocationView(Modifier.weight(4f))
                QRCodeScannerView(Modifier.weight(0.5f))
            }
            SearchView(Modifier.padding(vertical = 20.dp))
            FilterComponent(Modifier.padding(vertical = 1.dp), filters, onFilterItemTapped)
            if(uiState.items.containsKey(HomePresenter.SectionType.CategorySection)){
                val categories =  uiState.items[HomePresenter.SectionType.CategorySection] as CategorySection
                CategoryComponent(modifier = Modifier.padding(vertical = 20.dp), state = categories, onItemClick = onFilterItemTapped)
            }
            if(uiState.items.containsKey(HomePresenter.SectionType.CategorySection)){
                val cuisines =  uiState.items[HomePresenter.SectionType.CuisineSection] as CuisineSection
                CuisineComponent(modifier = Modifier.padding(vertical = 15.dp), state = cuisines, onItemClick = onFilterItemTapped, onShowMoreClick = onShowMoreClick)
            }
            RestaurantComponent(modifier = Modifier.padding(vertical = 15.dp), restaurants, onItemClick = onFilterItemTapped)
        }
    }
}

