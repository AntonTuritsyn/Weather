package com.turitsynanton.android.weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.turitsynanton.android.weather.R
import com.turitsynanton.android.weather.adapter.WeatherListAdapter
import com.turitsynanton.android.weather.databinding.FragmentWeatherBinding
import kotlinx.coroutines.launch

// фрагмент для отображения погоды
class WeatherDaysFragment : Fragment() {
    // безопасная привязка макета фрагмента к коду
    private var _binding: FragmentWeatherBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Ошибка привязки View"
        }

    // создание экземпляра ViewModel с учетом ЖЦ фрагмента
    private val weatherDaysViewModel: WeatherDaysViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        binding.weatherDaysList.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//  Внутри блока асинхронно происходит сбор данных из ViewModel.
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                weatherDaysViewModel.dayElements.collect { elements ->
                    binding.weatherDaysList.adapter = WeatherListAdapter(elements)
                }
            }
        }
    }
// вызывается когда представление фрагмента должно уничтожиться, чтобы избежать утечек памяти
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}