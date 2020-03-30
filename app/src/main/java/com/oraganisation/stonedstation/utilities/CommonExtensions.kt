package com.oraganisation.stonedstation.utilities

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Checks network connectivity
 */
val Context.isNetworkConnected: Boolean
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnected == true
    }


/**
 * Extension function to use the Observer when the LifeCycleOwner cannot be used<br/>
 * This observer will receive only one event and then it removes itself
 */
fun <T> LiveData<T>.observeOnce(observer: Observer<T>) {
    observeForever(object : Observer<T> {
        override fun onChanged(t: T?) {
            observer.onChanged(t)
            removeObserver(this)
        }
    })
}