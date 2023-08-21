package com.turitsynanton.android.weather.api

import com.squareup.moshi.JsonClass

// класс для получения всей информации о погоде
@JsonClass(generateAdapter = true)
data class WeatherResponse(
    val forecast: Forecast
)
