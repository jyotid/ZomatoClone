package com.jetpackcompose.core.models

import com.squareup.moshi.Json

data class Cuisine(
    @field:Json(name = "cuisine_id")val id : String,
    @field:Json(name = "cuisine_name")val name : String
)
