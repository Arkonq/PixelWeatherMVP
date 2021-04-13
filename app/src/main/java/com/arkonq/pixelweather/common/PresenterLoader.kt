package com.arkonq.pixelweather.common

import android.content.Context
import android.support.v4.content.Loader
import android.util.Log

internal class PresenterLoader<T : Presenter<*>>(context: Context, private val factory: PresenterFactory<T>, private val tag: String) : Loader<T>(context) {
    var presenter: T? = null
        private set

    override fun onStartLoading() {
        Log.i("loader", "onStartLoading-" + tag)

        // если экземпляр presenter'a уже создан, то просто вызываем его
        if (presenter != null) {
            deliverResult(presenter)
            return
        }

        // при отсутствии presenter'a загружаем его принудительно
        forceLoad()
    }

    override fun onForceLoad() {
        Log.i("loader", "onForceLoad-" + tag)

        // Создание Presenter'a через Factory
        presenter = factory.create()

        // Доставка результата
        deliverResult(presenter)
    }

    override fun deliverResult(data: T?) {
        super.deliverResult(data)
        Log.i("loader", "deliverResult-" + tag)
    }

    override fun onStopLoading() {
        Log.i("loader", "onStopLoading: " + tag)
    }

    override fun onReset() {
        Log.i("loader", "onReset-" + tag)
        if (presenter != null) {
            presenter?.onDestroyed()
            presenter = null
        }
    }
}