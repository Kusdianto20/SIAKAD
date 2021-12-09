package com.project01.siakad1.ui.potensi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project01.siakad1.R
import kotlinx.android.synthetic.main.activity_detail_lowongan.*

class DetailLowonganActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val  EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_lowongan)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvNameLow  = intent.getStringExtra(EXTRA_NAME)
        val tvDetailLow = intent.getStringExtra(EXTRA_DETAIL)
        val imgPhotoLow = intent.getIntExtra(EXTRA_PHOTO, 0)

        setActionBarTitle(tvNameLow.toString())

        tv_detail_lowongan.text = tvNameLow
        tv_detail_deskripsi_lowongan.text = tvDetailLow
        Glide.with(this)
            .load(imgPhotoLow)
            .into(iv_avatar_detail_lowongan)
    }

    private fun setActionBarTitle(it: String) {
        if (supportActionBar!=null) {
            supportActionBar?.title = it
        }
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