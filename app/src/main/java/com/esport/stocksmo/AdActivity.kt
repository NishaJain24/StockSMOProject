package com.esport.stocksmo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import timber.log.Timber

class AdActivity : AppCompatActivity() {
    private var interstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        checkAccessibilityPermission()

        MobileAds.initialize(this) {
            loadAd()
        }
    }

    private fun checkAccessibilityPermission() {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        startActivity(intent)
        Toast.makeText(this, "Enable Accessibility Service for the app", Toast.LENGTH_LONG).show()
    }

    private fun loadAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    interstitialAd?.show(this@AdActivity)
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e("AdMob", "Ad failed to load: ${error.message}")
                    finish() // Close activity if no ad
                }
            })




    }
}
