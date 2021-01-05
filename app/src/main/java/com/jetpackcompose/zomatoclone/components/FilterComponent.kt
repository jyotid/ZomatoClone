package com.jetpackcompose.zomatoclone.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.home.HomePresenter.Item.FilterItem
import com.jetpackcompose.zomatoclone.home.HomePresenter.SectionNew.FilterSection

@Composable
fun FilterComponent(modifier: Modifier, state : FilterSection, onItemClick: (FilterItem) -> Unit) {
    ScrollableRow(modifier = modifier) {
        state.list.forEach {
            getFilterPill(it, it.isSelected, onItemClick)
        }
    }
}

@Composable
fun getFilterPill(item: FilterItem, shouldHighlight: Boolean, onItemClick: (FilterItem) -> Unit) {
    Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp).border(
                    width = 1.dp,
                    color = getBorderColor(shouldHighlight),
                    shape = RoundedCornerShape(5.dp)
            ).background(color = getBackgroundColor(shouldHighlight))
                    .clickable(onClick = { onItemClick(item) })
    ) {
        val drawableRes = item.drawableRes
        drawableRes?.let { Icon(asset = vectorResource(id = drawableRes)) }
        Text(
                maxLines = 1,
                text = item.label,
                fontSize = 12.sp,
                color = colorResource(id = R.color.grey_shade2),
                modifier = Modifier.padding(10.dp),
        )
    }
}

@Composable
fun getBackgroundColor(shouldHighlight: Boolean): Color {
    return if (shouldHighlight) {
        colorResource(R.color.grey_shade1)
    } else {
        colorResource(R.color.white)
    }
}

@Composable
fun getBorderColor(shouldHighlight: Boolean): Color {
    return if (shouldHighlight) {
        colorResource(R.color.black)
    } else {
        colorResource(R.color.grey_shade1)
    }
}
