package com.project01.siakad1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.project01.siakad1.R
import kotlinx.android.synthetic.main.activity_nilai.*

class NilaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

        ll_semester2.setOnClickListener {
            Toast.makeText(this, "NIlai Semeter 2", Toast.LENGTH_SHORT).show()
        }

        ll_semester3.setOnClickListener {
            Toast.makeText(this, "NIlai Semeter 3", Toast.LENGTH_SHORT).show()
        }

        ll_semester4.setOnClickListener {
            Toast.makeText(this, "NIlai Semeter 4", Toast.LENGTH_SHORT).show()
        }

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Nilai"
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