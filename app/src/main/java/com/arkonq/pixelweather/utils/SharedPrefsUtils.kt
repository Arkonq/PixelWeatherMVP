package com.arkonq.pixelweather.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject


class SharedPrefsUtils @Inject
constructor(context: Context) {
    private val prefs: SharedPreferences

    var lastCityQueried: String?
        get() = getPrefsData(LAST_CITY_QUERIED_KEY, null)
        set(query) {
            println("setLastCityQueried = " + query)
            setSharedPreferencesData(LAST_CITY_QUERIED_KEY, query)
        }

    var cachedWeatherReport: String?
        get() {
            return getPrefsData(CACHED_WEATHER_REPORT_KEY, null)
        }
        set(weatherReport) {
            setSharedPreferencesData(CACHED_WEATHER_REPORT_KEY, weatherReport)
        }

    init {
        prefs = getSharedPreferences(context)
    }

    private fun getPrefsData(key: String, defValue: String?): String? {
        return prefs.getString(key, defValue)
    }

    private fun setSharedPreferencesData(key: String, defValue: String?) {
        prefs.edit()
                .putString(key, defValue)
                .apply()
    }

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    companion object {

        private val PREFS_NAME = "prefs"
        private val CACHED_WEATHER_REPORT_KEY = "cached_weather_report"
        private val LAST_CITY_QUERIED_KEY = "last_city_queried"
    }
}
