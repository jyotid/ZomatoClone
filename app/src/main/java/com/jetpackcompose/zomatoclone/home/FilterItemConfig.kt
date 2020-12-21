package com.jetpackcompose.zomatoclone.home

data class FilterItem(val id : Int, val label: String, val drawableRes: Int?, var isSelected: Boolean = false)

data class Category(val id : Int, val label: String, val drawableRes: Int)

data class Cuisine(val id: Int, val label: String, val drawableRes: Int)

class ShowMoreUiState(var label : String,  inline var onClick:()->Unit)
