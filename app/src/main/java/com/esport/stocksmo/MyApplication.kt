package com.esport.stocksmo

import android.app.Application
import android.util.Log
import com.google.android.gms.ads.MobileAds

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) { initializationStatus ->
            Log.d("AdMob", "SDK Initialized: $initializationStatus")
        }
    }
}
