package com.jetpackcompose.core

import com.jetpackcompose.core.models.Cuisines
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("/cuisine")
    fun getCuisine(@Query("city_id") city : Int = 2) : Single<Cuisines>
}
