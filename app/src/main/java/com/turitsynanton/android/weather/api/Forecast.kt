package com.turitsynanton.android.weather.api

import com.squareup.moshi.JsonClass

// класс для получения списка дней с соответствующей информацией
@JsonClass(generateAdapter = true)
data class Forecast(
    val forecastday: List<ForecastDay>
)
