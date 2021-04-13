package com.arkonq.pixelweather.common

/**
 * Создает объект Presenter'a.
 * @param <T> presenter type
</T> */
interface PresenterFactory<T : Presenter<*>> {
    fun create(): T
}