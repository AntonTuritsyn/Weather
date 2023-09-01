package com.turitsynanton.android.weather.url

import com.turitsynanton.android.weather.api.ForecastDay
import com.turitsynanton.android.weather.api.WeatherApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/* репозиторий, который взаимодействует с внешним API для получения данных о прогнозе погоды,
    и предоставляет функцию для получения данных*/
class WeatherRepository {

    private val weatherApi: WeatherApi
    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(WeatherInterceptor())
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        weatherApi = retrofit.create()
    }
// функция для асинхронного получения данных о прогнозе погоды
    suspend fun fetchForecast(): List<ForecastDay> = weatherApi.fetchCity().forecast.forecastday
}