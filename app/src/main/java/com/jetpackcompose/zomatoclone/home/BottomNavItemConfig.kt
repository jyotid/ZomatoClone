package com.jetpackcompose.zomatoclone.home

enum class Route{
    ORDER_SCREEN,
    GOOUT_SCREEN,
    PRO_SCREEN,
    PROFILE_SCREEN
}
sealed class Item(open val route : Route, open var text: String, open val drawableRes: Int)
data class Order(override val route : Route,override var text: String, override val drawableRes: Int) :
    Item(route = route,text = text, drawableRes = drawableRes)

data class GoOut(override val route : Route,override var text: String, override val drawableRes: Int) :
    Item(route = route,text = text, drawableRes = drawableRes)

data class Pro(override val route : Route, override var text: String, override val drawableRes: Int) :
    Item(route= route,text = text, drawableRes = drawableRes)

data class Profile(override val route : Route, override var text: String, override val drawableRes: Int) :
    Item(route = route,text = text, drawableRes = drawableRes)
