package com.arkonq.pixelweather.dagger

import com.arkonq.pixelweather.weather.WeatherActivity
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, SharedPrefModule::class))
interface AppComponent {
    fun inject(target: WeatherActivity)
}
