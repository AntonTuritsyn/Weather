package com.turitsynanton.android.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.turitsynanton.android.weather.api.ForecastDay
import com.turitsynanton.android.weather.databinding.WeatherDetailsBinding

// стандартный адаптер для отображения элементов RecyclerView
class WeatherListAdapter(
    private val forecast: List<ForecastDay>
) : RecyclerView.Adapter<WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WeatherDetailsBinding.inflate(inflater, parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val day = forecast[position]
        holder.bind(day)
    }

    override fun getItemCount() = forecast.size
}