package com.jetpackcompose.zomatoclone.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.components.FilterComponent
import com.jetpackcompose.zomatoclone.components.LocationView
import com.jetpackcompose.zomatoclone.components.QRCodeScannerView
import com.jetpackcompose.zomatoclone.components.SearchView
import com.jetpackcompose.zomatoclone.home.FilterItem

@Composable
fun OrderScreen() {
    val filterItems = mutableStateListOf(
            FilterItem(1, "Filter", R.drawable.ic_filter),
            FilterItem(2, "Bookmarks", R.drawable.ic_bookmark),
            FilterItem(1, "Rating: 4.0+", null, true),
            FilterItem(2, "Safe and hygenice", null)
    )
    Column(modifier = Modifier.padding(15.dp)) {
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
    }
}


