package com.project01.siakad1.ui.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project01.siakad1.databinding.ActivityFaqactivityBinding

class FAQActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFaqactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "FAQ"

    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}