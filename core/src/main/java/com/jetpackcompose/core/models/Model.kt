package com.jetpackcompose.core.models

import com.squareup.moshi.Json

data class Cuisines(@field:Json(name = "cuisines") val cuisines : List<CuisineItem>)
data class CuisineItem(@field:Json(name = "cuisine") val cuisine : Cusine)
data class Cusine ( @field:Json(name = "cuisine_id")val id : String,
                   @field:Json(name = "cuisine_name")val name : String)
