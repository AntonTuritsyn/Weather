package com.turitsynanton.android.weather.api

import com.squareup.moshi.JsonClass

// класс для получения описания и иконки
@JsonClass(generateAdapter = true)
data class Condition(
    val text: String,
    val icon: String
)
