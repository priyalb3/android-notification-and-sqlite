package com.example.notificationandsqllite

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class Servicese : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show()
    }

//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show()
//        return super.onStartCommand(intent, flags, startId)
//    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Service Stop",Toast.LENGTH_SHORT).show()
    }
}