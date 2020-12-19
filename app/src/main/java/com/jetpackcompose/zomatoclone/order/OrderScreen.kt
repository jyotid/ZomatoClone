package com.jetpackcompose.zomatoclone.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpackcompose.zomatoclone.components.LocationView
import com.jetpackcompose.zomatoclone.components.QRCodeScannerView

@Composable
fun OrderScreen() {
    Column(modifier = Modifier.padding(15.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            LocationView(Modifier.weight(4f))
            QRCodeScannerView(Modifier.weight(0.5f))
        }
    }
}


