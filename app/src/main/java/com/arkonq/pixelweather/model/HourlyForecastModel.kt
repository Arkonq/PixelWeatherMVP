package com.arkonq.pixelweather.model

import com.arkonq.pixelweather.utils.DateFormatter


class HourlyForecastModel internal constructor(
        val tempMax: Float,
        val tempMin: Float,
        val icon: String,
        val dateTime: Long
) {
    var dayOfWeek: String = DateFormatter.dayFormat(dateTime)

    override fun toString(): String {
        return "HourlyForecastModel(tempMax=$tempMax, tempMin=$tempMin, icon='$icon', dateTime=$dateTime, dayOfWeek='$dayOfWeek')"
    }
}
