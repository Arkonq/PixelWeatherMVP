package com.arkonq.pixelweather

import android.app.Application

import com.arkonq.pixelweather.dagger.AppComponent
import com.arkonq.pixelweather.dagger.AppModule
import com.arkonq.pixelweather.dagger.DaggerAppComponent
import com.arkonq.pixelweather.dagger.NetworkModule
import com.arkonq.pixelweather.dagger.SharedPrefModule

class PixelWeatherApplication : Application() {

    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = createComponent()
    }

    private fun createComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .sharedPrefModule(SharedPrefModule())
                .build()
    }
}
