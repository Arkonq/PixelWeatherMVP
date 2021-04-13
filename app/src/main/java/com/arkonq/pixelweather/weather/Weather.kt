package com.arkonq.pixelweather.weather

import com.arkonq.pixelweather.model.WeatherReport


interface Weather {

    interface View {

        fun showLoading(show: Boolean)

        fun showError(error: String?)

        fun showWeatherReport(weatherReport: WeatherReport)

    }
}