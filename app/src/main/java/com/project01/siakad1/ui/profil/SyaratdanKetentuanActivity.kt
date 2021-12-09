package com.project01.siakad1.ui.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project01.siakad1.R

class SyaratdanKetentuanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syaratdan_ketentuan)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Syarat dan Ketentuan"

    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}