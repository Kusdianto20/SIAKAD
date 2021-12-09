package com.project01.siakad1.ui.tugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.project01.siakad1.R
import com.project01.siakad1.databinding.ActivityTugasBinding
import kotlinx.android.synthetic.main.activity_tugas.*

class TugasActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTugasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tugas"

        onClick()
    }

    private fun onClick() {
        binding.btnDetTugas1.setOnClickListener {
            val detailTugasActivity = Intent(this, DetailTugasActivity::class.java)
            startActivity(detailTugasActivity)
        }

        binding.btnDetTugas2.setOnClickListener {
            val detailTugasActivity = Intent(this, DetailTugasActivity::class.java)
            startActivity(detailTugasActivity)
        }

        binding.btnDetTugas3.setOnClickListener {
            val detailTugasActivity = Intent(this, DetailTugasActivity::class.java)
            startActivity(detailTugasActivity)
        }
    }
}