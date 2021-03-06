package com.arkonq.pixelweather.http

import com.arkonq.pixelweather.model.CurrentWeatherResponse
import com.arkonq.pixelweather.model.ForecastResponse

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenWeatherClient {

    @GET("data/2.5/weather")
    fun getCurrentWeather(
            @Query("q") query: String,
            @Query("units") unit: String,
            @Query("APPID") apiKey: String): Single<CurrentWeatherResponse>

    @GET("data/2.5/forecast")
    fun getForecast(
            @Query("q") query: String,
            @Query("units") unit: String,
            @Query("APPID") apiKey: String): Single<ForecastResponse>
}

