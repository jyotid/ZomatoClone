package com.jetpackcompose.zomatoclone.components

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import com.jetpackcompose.zomatoclone.R

@Composable
fun QRCodeScannerView(modifier: Modifier) {
    Icon(asset = vectorResource(id = R.drawable.ic_qr_code_scanner), modifier = modifier)
}
