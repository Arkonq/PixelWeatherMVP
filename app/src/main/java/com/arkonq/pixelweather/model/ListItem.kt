package com.arkonq.pixelweather.model

import com.google.gson.annotations.SerializedName

class ListItem(
        @SerializedName("dt") var dt: Int,
        @SerializedName("weather") var weather: List<WeatherItem>,
        @SerializedName("main") var main: Main,
        @SerializedName("clouds") var clouds: Clouds,
        @SerializedName("sys") var sys: Sys,
        @SerializedName("wind") var wind: Wind
)
