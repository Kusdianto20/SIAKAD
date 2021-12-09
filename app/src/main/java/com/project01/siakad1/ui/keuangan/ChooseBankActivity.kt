package com.project01.siakad1.ui.keuangan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project01.siakad1.R

class ChooseBankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_bank)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pilih Bank"
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}