package com.jetpackcompose.zomatoclone.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.jetpackcompose.zomatoclone.R

@Composable
fun LocationView(modifier: Modifier) {
    Row (modifier = modifier){
        Icon(vectorResource(id = R.drawable.ic_location))
        Text(
                text = "Janakipuram",
                textDecoration = TextDecoration.Underline ,
                color = colorResource(R.color.dark_grey),
                modifier = Modifier.padding(horizontal = 5.dp),
                fontSize = TextUnit.Sp(18),
                style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}
