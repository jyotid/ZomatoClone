package com.jetpackcompose.zomatoclone.home


class ShowMoreUiState(var label : String, var drawableRes: Int, inline var onClick:()->Unit)

data class CusineListUiState(val items : List<HomePresenter.Section.Cuisine>, var isExpanded: Boolean)
