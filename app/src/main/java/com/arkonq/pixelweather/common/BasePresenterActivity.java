package com.arkonq.pixelweather.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public abstract class BasePresenterActivity<P extends Presenter<V>, V> extends AppCompatActivity {

    public abstract void initializeDagger();
    private static final String TAG = "base-activity";
    private static final int LOADER_ID = 101;
    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();

        Loader<P> loader = getSupportLoaderManager().getLoader(loaderId());
        if (loader == null) {
            initLoader();
        } else {
            this.presenter = ((PresenterLoader<P>) loader).getPresenter();
            onPresenterCreatedOrRestored(presenter);
        }
    }

    private void initLoader() {
        getSupportLoaderManager().initLoader(loaderId(), null, new LoaderManager.LoaderCallbacks<P>() {
            @Override
            public final Loader<P> onCreateLoader(int id, Bundle args) {
                Log.i(TAG, "onCreateLoader");
                return new PresenterLoader<>(BasePresenterActivity.this, getPresenterFactory(), tag());
            }

            @Override
            public final void onLoadFinished(Loader<P> loader, P presenter) {
                Log.i(TAG, "onLoadFinished");
                BasePresenterActivity.this.presenter = presenter;
                onPresenterCreatedOrRestored(presenter);
            }

            @Override
            public final void onLoaderReset(Loader<P> loader) {
                Log.i(TAG, "onLoaderReset");
                BasePresenterActivity.this.presenter = null;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart-" + tag());
        presenter.onViewAttached(
                getPresenterView());
    }

    @Override
    protected void onStop() {
        presenter.onViewDetached();
        super.onStop();
        Log.i(TAG, "onStop-" + tag());
    }

    @NonNull
    protected abstract String tag();

    @NonNull
    protected abstract PresenterFactory<P> getPresenterFactory();

    protected abstract void onPresenterCreatedOrRestored(@NonNull P presenter);

    @NonNull
    protected V getPresenterView() {
        return (V) this;
    }

    protected int loaderId() {
        return LOADER_ID;
    }

}