package com.project01.siakad1.ui.perpustakaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project01.siakad1.R
import com.project01.siakad1.ui.pengumuman.DetailPengumumanActivity
import kotlinx.android.synthetic.main.activity_detail_pengumuman.*
import kotlinx.android.synthetic.main.activity_detail_perpustakaan.*

class DetailPerpustakaanActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_DATA2 = "extra_data2"
        const val EXTRA_DATA3 = "extra_data3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_perpustakaan)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvName  = intent.getStringExtra(EXTRA_DATA)
        val tvDetail = intent.getStringExtra(EXTRA_DATA2)
        val imgPhoto = intent.getIntExtra(EXTRA_DATA3, 0)
        val imgPohotSmaal = intent.getIntExtra(EXTRA_DATA3,0)

        setActionBarTitle(tvName.toString())

        tv_detail_buku.text = tvName
        tv_detail_deskripsi_buku.text = tvDetail
        iv_avatar_detail_buku_small.tag = imgPohotSmaal
        Glide.with(this)
            .load(imgPhoto)
            .into(iv_avatar_detail_buku)

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