package com.arkonq.pixelweather.dagger

import android.content.Context

import com.arkonq.pixelweather.utils.SharedPrefsUtils

import dagger.Module
import dagger.Provides


@Module
class SharedPrefModule {

    @Provides
    internal fun provideSharedPrefUtils(context: Context): SharedPrefsUtils {
        return SharedPrefsUtils(context)
    }
}
