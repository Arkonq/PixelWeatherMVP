package com.arkonq.pixelweather.model

class FiveDayForecastModel(
        var tempMax: Float,
        var tempMin: Float,
        var icon: String,
        var dayOfWeek: String
) {
    var hourlyForecast: MutableList<HourlyForecastModel> = ArrayList()

    override fun toString(): String {
        return "FiveDayForecastModel(tempMax=$tempMax, tempMin=$tempMin, icon=$icon, dayOfWeek=$dayOfWeek, fiveDayForecast=$hourlyForecast)"
    }
}
