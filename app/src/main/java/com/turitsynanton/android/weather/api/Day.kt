package com.turitsynanton.android.weather.api

import com.squareup.moshi.JsonClass

// класс для получения основных погодных показателей дня
@JsonClass(generateAdapter = true)
data class Day(
    val avgtemp_c: Double,
    val maxwind_mph: Double,
    val avghumidity: Int,
    val condition: Condition
)