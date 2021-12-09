package com.project01.siakad1.ui.perpustakaan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project01.siakad1.R
import com.project01.siakad1.adapter.AdapterPengumuman
import com.project01.siakad1.adapter.AdapterPerpustakaan
import com.project01.siakad1.dummy.DataBuku
import com.project01.siakad1.dummy.DataPengumuman
import com.project01.siakad1.dummy.Pengumuman
import com.project01.siakad1.ui.pengumuman.DetailPengumumanActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_perputakaan.*

class PerputakaanActivity : AppCompatActivity() {

    private var list: ArrayList<Pengumuman> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perputakaan)

        rvListConfig()
        list.addAll(DataBuku.listData)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Perpustakaan"
    }

    private fun rvListConfig() {
        val adapterPerpustakaan =  AdapterPerpustakaan(list)
        rv_perpustakaan.adapter = adapterPerpustakaan
        rv_perpustakaan.layoutManager = LinearLayoutManager(this)

        adapterPerpustakaan.setOnItemClickCallback(object : AdapterPerpustakaan.OnItemClickCallback {
            override fun onItemClicked(pengumuman: Pengumuman) {
                showSelectedHero(pengumuman)
            }
        })
    }

    private fun showSelectedHero(pengumuman: Pengumuman) {

        val intentDetail = Intent(this, DetailPerpustakaanActivity::class.java)
        startActivity(intentDetail)

        Toast.makeText(this, "Kamu memilih " + pengumuman.names, Toast.LENGTH_SHORT).show()
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