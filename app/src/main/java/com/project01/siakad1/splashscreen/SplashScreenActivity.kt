package com.project01.siakad1.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.project01.siakad1.MainActivity
import com.project01.siakad1.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    private val timeOut: Long = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, timeOut)
    }
}