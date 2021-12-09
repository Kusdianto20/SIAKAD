package com.project01.siakad1.ui.pengumuman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project01.siakad1.dummy.DataPengumuman
import com.project01.siakad1.dummy.Pengumuman
import com.project01.siakad1.R
import com.project01.siakad1.adapter.AdapterPengumuman
import kotlinx.android.synthetic.main.activity_main.*

class PengumumanActivity : AppCompatActivity() {

    private lateinit var rvPengumuman : RecyclerView
    private var list: ArrayList<Pengumuman> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman)

        rvListConfig()
        list.addAll(DataPengumuman.listData)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pengumuman"
    }

    private fun rvListConfig() {
        val adapterPengumuman =  AdapterPengumuman(list)
        rv_pengumuman.adapter = adapterPengumuman
        rv_pengumuman.layoutManager = LinearLayoutManager(this)

       adapterPengumuman.setOnItemClickCallback(object : AdapterPengumuman.OnItemClickCallback {
            override fun onItemClicked(pengumuman: Pengumuman) {
                showSelectedHero(pengumuman)
            }
        })
    }

    private fun showSelectedHero(pengumuman: Pengumuman) {

        val intentDetail = Intent(this, DetailPengumumanActivity::class.java)
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