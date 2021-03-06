package com.arkonq.pixelweather.utils


import android.Manifest.permission.*
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.ConnectivityManager
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

/**
 * Содержит базовые методы
 */
object AppUtils {

    fun isOnline(context: Context): Boolean {
        var isConnected: Boolean
        val conectivtyManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        isConnected = (conectivtyManager.activeNetworkInfo != null
                && conectivtyManager.activeNetworkInfo.isAvailable
                && conectivtyManager.activeNetworkInfo.isConnected)

        return isConnected
    }

    fun checkPermissions(activity: Activity): Boolean {
        return (ContextCompat.checkSelfPermission(activity, ACCESS_FINE_LOCATION) != PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(activity, ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(activity, READ_EXTERNAL_STORAGE) != PERMISSION_GRANTED)
    }

    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager?.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
    }

    fun clearText(view: EditText) {
        view.setText("")
    }

    fun showSnackBar(view: View, text: String) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
    }

    fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}

