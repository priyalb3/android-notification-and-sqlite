package com.example.notificationandsqllite

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var notificationManger : NotificationManager
    lateinit var builder: Notification.Builder
    private var chennelId = "com.example.notificationandsqllite"

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notifyme_button.setOnClickListener{

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                builder = Notification.Builder(this,chennelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Hello User")
                    .setContentText("You are Moving")
            }else{
                builder = Notification.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Hello")
                    .setContentText("You are Moving")
            }
            notificationManger.notify(1234,builder.build())

            startActivity(Intent(this,Main2Activity::class.java))

        }

        service_start_button.setOnClickListener {
            startService(Intent(this,Servicese::class.java))
        }

        service_stop_button.setOnClickListener {
            stopService(Intent(this,Servicese::class.java))
        }

    }
}
