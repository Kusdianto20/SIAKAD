package com.project01.siakad1.ui.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project01.siakad1.R
import com.project01.siakad1.databinding.ActivityAbsensiBinding.inflate
import com.project01.siakad1.databinding.ActivityDataDiriBinding
import com.project01.siakad1.databinding.ActivityProfilBinding

class DataDiriActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataDiriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataDiriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Data Diri"

    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}
