package com.jetpackcompose.zomatoclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.zomatoclone.home.HomePresenter.Section.Restaurants

@Composable
fun RestaurantComponent(modifier: Modifier, items: List<Restaurants>, onItemClick: (Restaurants) -> Unit) {
    Text(text = "${items.size} Restaurants around you")
    Column(modifier = modifier) {
        items.forEach {
            getRestaurantCard(it, onItemClick = onItemClick)
        }

    }

}

@Composable
fun getRestaurantCard(item: Restaurants, onItemClick: (Restaurants) -> Unit) {
    Card(modifier = Modifier.padding(5.dp), elevation = 8.dp) {
        Column(modifier = Modifier.clickable(onClick = { onItemClick(item) })) {
            Image(contentScale = ContentScale.FillWidth, asset = imageResource(id = item.drawableRes), modifier = Modifier.fillMaxWidth().fillMaxHeight(fraction = 0.5f))
            Text(textAlign = TextAlign.Center, text = item.name, fontSize = 12.sp, modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp))
        }
    }
}

