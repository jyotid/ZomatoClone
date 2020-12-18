package com.jetpackcompose.zomatoclone.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import com.jetpackcompose.zomatoclone.R

sealed class Item(open val text: String, open val drawableRes: Int)
data class Order(override val text: String, override val drawableRes: Int) :
    Item(text = text, drawableRes = drawableRes)

data class GoOut(override val text: String, override val drawableRes: Int) :
    Item(text = text, drawableRes = drawableRes)

data class Pro(override val text: String, override val drawableRes: Int) :
    Item(text = text, drawableRes = drawableRes)

data class Profile(override val text: String, override val drawableRes: Int) :
    Item(text = text, drawableRes = drawableRes)

@Composable
fun BottomNavigator() {
    val items = listOf(
        Order("Order", R.drawable.ic_order),
        GoOut("Go Out", R.drawable.ic_go_out),
        Pro("Pro", R.drawable.ic_premium),
        Profile("Profile", R.drawable.ic_profile)
    )
    val selectedItem = mutableStateOf(items[0])

    BottomNavigation(backgroundColor = Color.White) {
        items.forEach { item ->
            getBottomNavigationItem(item, selectedItem = selectedItem.value) {
                selectedItem.value = item
            }
        }
    }

}

@Composable
fun getBottomNavigationItem(currentItem: Item, selectedItem: Item, onClick: () -> Unit) {
    BottomNavigationItem(
        label = { Text(text = currentItem.text) },
        icon = { Icon(vectorResource(id = currentItem.drawableRes)) },
        selected = currentItem == selectedItem,
        onClick = onClick
    )
}
