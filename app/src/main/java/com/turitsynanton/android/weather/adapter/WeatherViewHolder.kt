package com.turitsynanton.android.weather.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.turitsynanton.android.weather.api.ForecastDay
import com.turitsynanton.android.weather.databinding.WeatherDetailsBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

// стандартный холдер для связывания данных с соответствующими представлениями
class WeatherViewHolder(
    private val binding: WeatherDetailsBinding
): RecyclerView.ViewHolder (binding.root) {


    fun bind(forecastDay: ForecastDay) {
        binding.icon.load("https:${forecastDay.day.condition.icon}")
        binding.condition.text = forecastDay.day.condition.text
        binding.temp.text = "${forecastDay.day.avgtemp_c}\u00B0"
        binding.wind.text = "Ветер: ${forecastDay.day.maxwind_mph.toString()} м/с"
        binding.humidity.text = "Влажность: ${forecastDay.day.avghumidity}%"
        binding.date.text = epochToDateString(forecastDay.date_epoch)
    }

    // преобразование даты из формата timestamp в строковое значение и возврат строки "день недели, дата"
    private fun epochToDateString(epoch: String): String {
        val date = Date(epoch.toLong() * 1000)
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
        val calendar = Calendar.getInstance()
        calendar.time = date
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return "${getDayOfWeekName(dayOfWeek)}${dateFormat.format(date)}"
    }
    // создание строковых шаблонов для каждого дня недели
    private fun getDayOfWeekName(dayOfWeek: Int): String {
        return when (dayOfWeek) {
            Calendar.MONDAY -> "пн, "
            Calendar.TUESDAY -> "вт, "
            Calendar.WEDNESDAY -> "ср, "
            Calendar.THURSDAY -> "чт, "
            Calendar.FRIDAY -> "пт, "
            Calendar.SATURDAY -> "сб, "
            Calendar.SUNDAY -> "вс, "
            else -> ""
        }
    }
}