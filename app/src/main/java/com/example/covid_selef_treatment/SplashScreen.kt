package com.example.covid_selef_treatment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler()
        handler.postDelayed({
            // Start loging class at the beginning
            //val intent = Intent(this, Login::class.java)
            val intent = Intent(this, activity_main::class.java)
            startActivity(intent)
            finish()
        } , 3000)

    }
}