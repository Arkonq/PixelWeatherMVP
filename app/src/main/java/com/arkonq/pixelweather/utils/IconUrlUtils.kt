package com.arkonq.pixelweather.utils


object IconUrlUtils {

    private const val ICON_BASE_URL = "http://openweathermap.org/img/w/"
    private const val PNG = ".png"

    fun getIconUrl(icon: String): String {
        return StringBuilder()
                .append(ICON_BASE_URL)
                .append(icon)
                .append(PNG)
                .toString()
    }

}
