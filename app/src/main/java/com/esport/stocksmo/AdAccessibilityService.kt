package com.esport.stocksmo

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.ads.AdActivity

class AdAccessibilityService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()
        startAdLoop()
    }

    private fun startAdLoop() {
        val handler = Handler(Looper.getMainLooper())
        val adRunnable = object : Runnable {
            override fun run() {
                showAd()
                handler.postDelayed(this, 60000) // Show ad every 60 seconds
            }
        }
        handler.post(adRunnable)
    }

    private fun showAd() {
        val intent = Intent(this, AdActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Not needed for periodic ads
    }

    override fun onInterrupt() {
        // Required override, no action needed
    }
}
