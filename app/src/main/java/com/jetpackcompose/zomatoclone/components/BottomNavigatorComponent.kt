package com.jetpackcompose.zomatoclone.components

import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.jetpackcompose.zomatoclone.home.Item


@Composable
fun BottomNavigatorComponent(items : List<Item>, navController: NavHostController) {
    val selectedItem = mutableStateOf(items[0])
    BottomNavigation(backgroundColor = Color.White) {
        items.forEach { item ->
            getBottomNavigationItem(item, selectedItem = selectedItem.value) {
                selectedItem.value = item
                navController.navigate(item.route.name)
            }
        }
    }
}

@Composable
fun getBottomNavigationItem(currentItem: Item, selectedItem: Item, onClick: () -> Unit) {
    BottomNavigationItem(
        label = { Text(text =currentItem.text ) },
        icon = { Icon(vectorResource(id = currentItem.drawableRes)) },
        selected = currentItem == selectedItem,
        onClick = onClick
    )
}
