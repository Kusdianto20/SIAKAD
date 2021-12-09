package com.project01.siakad1.ui.potensi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project01.siakad1.R
import kotlinx.android.synthetic.main.activity_detail_kompetensi.*

class DetailKompetensiActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kompetensi)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Kompetensi"

        val tvNameKom  = intent.getStringExtra(EXTRA_NAME)
        val tvDetailKom = intent.getStringExtra(EXTRA_DETAIL)

        tv_detail_kompetensi.text = tvNameKom
        tv_detail_deskripsi_kompetensi.text = tvDetailKom
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