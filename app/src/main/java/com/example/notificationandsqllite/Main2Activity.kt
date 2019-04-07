package com.example.notificationandsqllite

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    var db : DataBaseHandeler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        db = DataBaseHandeler(this)

        submit_button.setOnClickListener {
            var user = User()
            user.name = name_text.text.toString()
            db!!.createUser(user)
        }

        show_button.setOnClickListener {
            text_view.text = db!!.fetchUser()
        }


    }
}
