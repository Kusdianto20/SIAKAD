package com.project01.siakad1.ui.pengumuman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project01.siakad1.R
import com.project01.siakad1.dummy.Pengumuman
import kotlinx.android.synthetic.main.activity_detail_pengumuman.*

class DetailPengumumanActivity : AppCompatActivity() {

    private var list: ArrayList<Pengumuman> = arrayListOf()

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_DATA2 = "extra_data2"
        const val EXTRA_DATA3 = "extra_data3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pengumuman)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvName  = intent.getStringExtra(EXTRA_DATA)
        val tvDetail = intent.getStringExtra(EXTRA_DATA2)
        val imgPhoto = intent.getIntExtra(EXTRA_DATA3, 0)

        setActionBarTitle(tvName.toString())

        tv_detail_pengumuman.text = tvName
        tv_detail_deskripsi_pengumuman.text = tvDetail
        Glide.with(this)
            .load(imgPhoto)
            .into(iv_avatar_detail_pengumuman)
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