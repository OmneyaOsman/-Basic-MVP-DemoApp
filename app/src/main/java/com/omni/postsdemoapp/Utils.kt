package com.omni.postsdemoapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 *created by Omni on 23/01/2019
 */

object Constants {
    const val API_BASE_URL = "https://jsonplaceholder.typicode.com"
}

fun hasNetwork(context: Context): Boolean? {
    var isConnected: Boolean? = false // Initial Value
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}