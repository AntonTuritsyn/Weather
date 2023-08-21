package com.turitsynanton.android.weather.url

import com.turitsynanton.android.weather.R
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

// реализация интерфейса Interceptor (Retrofit2) для изменения запросов и ответов при выполнении сетевых вызовов.
private const val API_KEY = "1971ae3814164dba91590534232108"
class WeatherInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest: Request = chain.request()

//      https://api.weatherapi.com/v1/forecast.json?q=%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0&days=5&lang=ru&key=1971ae3814164dba91590534232108 (пример для составления билдера)
        val newUrl: HttpUrl = originalRequest.url.newBuilder()
            .addQueryParameter("q", "Нижний Новгород")
            .addQueryParameter("days", "5")
            .addQueryParameter("lang", "ru")
            .addQueryParameter("key", API_KEY)
            .build()

        val newRequest: Request = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}