package com.jetpackcompose.zomatoclone.components

import android.text.Layout
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.drawBorder
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.zomatoclone.R

@Composable
fun SearchView(modifier: Modifier) {
    val state = savedInstanceState(saver = TextFieldValue.Saver) { TextFieldValue() }
        TextField(
                textStyle = TextStyle(fontSize = 14.sp),
                value = state.value,
                leadingIcon = {
                    Icon(asset = vectorResource(id = R.drawable.ic_search))
                },
                onValueChange = { state.value = it },
                backgroundColor = Color.White,
                activeColor = Color.White,
                modifier = modifier.fillMaxWidth().border(width = 2.dp, color = colorResource(id = R.color.grey), shape = RoundedCornerShape(30.dp)),
                placeholder = {
                    Text(
                            maxLines = 1,
                            text = "Restaurant name, cuisine, or a dish...",
                            fontSize = 14.sp
                    )
                },
        )

}
