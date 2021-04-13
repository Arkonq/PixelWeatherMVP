package com.arkonq.pixelweather.weather

import com.arkonq.pixelweather.common.PresenterFactory
import com.arkonq.pixelweather.utils.SharedPrefsUtils
import javax.inject.Inject

class WeatherPresenterFactory @Inject constructor(
        private val sharedPrefsUtils: SharedPrefsUtils,
        private val weatherInteractor: WeatherInteractor) : PresenterFactory<WeatherPresenter> {

    override fun create(): WeatherPresenter {
        return WeatherPresenter(sharedPrefsUtils, weatherInteractor)
    }
}