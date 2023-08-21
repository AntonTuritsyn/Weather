package com.turitsynanton.android.weather.api

import retrofit2.http.GET
import retrofit2.http.Query

// интерфейс для взаимодействия с API и асинхронного получения информации
interface WeatherApi {
    @GET("forecast.json")
    suspend fun fetchCity(): WeatherResponse
}