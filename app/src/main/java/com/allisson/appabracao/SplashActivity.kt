package com.allisson.appabracao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val background = object : Thread(){
            override fun run() {
                try {
                    sleep(5000)
                    val intent = Intent(baseContext, Login::class.java)
                    startActivity(intent)
                    finish()
                } catch (e:Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
