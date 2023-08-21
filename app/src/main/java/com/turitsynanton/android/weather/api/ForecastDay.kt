package com.turitsynanton.android.weather.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// класс для получения даты
@JsonClass(generateAdapter = true)
data class ForecastDay(
    @Json(name = "day") val day: Day,
    val date_epoch: String
)
