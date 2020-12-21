package com.jetpackcompose.zomatoclone.components

import androidx.compose.foundation.ClickableText
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.home.FilterItem

@Composable
fun FilterComponent(modifier: Modifier, items: List<FilterItem>, onItemClick: (FilterItem) -> Unit) {
    ScrollableRow(modifier = modifier) {
        items.forEach {
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
    ) {
        val drawableRes = item.drawableRes
        drawableRes?.let { Icon(asset = vectorResource(id = drawableRes)) }
        ClickableText(
                maxLines = 1,
                text = AnnotatedString(item.label),
                style = TextStyle(color = colorResource(id = R.color.grey_shade2), fontSize = 12.sp),
                modifier = Modifier.padding(10.dp),
                onClick = { onItemClick(item) }
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
