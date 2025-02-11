package com.jetpackcompose.zomatoclone.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.home.HomePresenter.Item.CategoryItem
import com.jetpackcompose.zomatoclone.home.HomePresenter.SectionNew.CategorySection

@Composable
fun CategoryComponent(modifier: Modifier, state : CategorySection, onItemClick: (CategoryItem) -> Unit){
    LazyRowFor(items = state.list, modifier = modifier) {
        getCard(it, onItemClick = onItemClick)
    }
}
@Composable
fun getCard(it: CategoryItem, onItemClick: (CategoryItem)-> Unit) {
   Card(modifier = Modifier.width(96.dp).height(96.dp).padding(5.dp), elevation = 8.dp) {
       Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable(onClick = { onItemClick(it) })) {
           Box(modifier = Modifier.background(color = colorResource(id = R.color.grey_shade1)).weight(2.0f).fillMaxWidth(), alignment = Alignment.Center){
               Image(asset = vectorResource(id = it.drawableRes))
           }
           Text(textAlign = TextAlign.Center,text = it.label, fontSize = 12.sp, modifier = Modifier.weight(1.0f).fillMaxWidth().padding(vertical = 5.dp))
       }
   }
}
