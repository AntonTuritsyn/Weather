package com.turitsynanton.android.weather.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turitsynanton.android.weather.url.WeatherRepository
import com.turitsynanton.android.weather.api.ForecastDay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


// стандартная ViewModel, предоставляющая логику для отображения UI
private const val TAG = "WeatherGalleryViewModel"
class WeatherDaysViewModel: ViewModel() {
// создание экземпляра репозитория
    private val weatherRepository = WeatherRepository()
    // безопасный доступ к данным о погоде
    private val _dayElements: MutableStateFlow<List<ForecastDay>> = MutableStateFlow(emptyList())
    val dayElements: StateFlow<List<ForecastDay>>
        get() = _dayElements.asStateFlow()
// асинхронная загрузка данных о погоде
    init {
        viewModelScope.launch {
                try {
                    val elements = weatherRepository.fetchForecast()
                    _dayElements.value = elements
                } catch (e: Exception) {
                    Log.e(TAG, "Не удалось получить данные", e)
                }

        }
    }
}