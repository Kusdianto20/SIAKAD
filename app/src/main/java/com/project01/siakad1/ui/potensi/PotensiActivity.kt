package com.project01.siakad1.ui.potensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project01.siakad1.R
import com.project01.siakad1.dummy.Data
import com.project01.siakad1.adapter.AdapterLowongan
import com.project01.siakad1.dummy.Bca
import com.project01.siakad1.adapter.AdapterKompetensi
import com.project01.siakad1.adapter.AdapterMagang
import com.project01.siakad1.dummy.Pengumuman
import com.project01.siakad1.ui.pengumuman.DetailPengumumanActivity
import kotlinx.android.synthetic.main.activity_potensi.*

class PotensiActivity : AppCompatActivity() {

    private lateinit var rvLowongnan: RecyclerView
    private var list: ArrayList<Bca> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_potensi)

        rvListConfig()
        list.addAll(Data.listData)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Potensi"
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun rvListConfig() {
        val adapterLowongan = AdapterLowongan(list)
        rv_lowongan.adapter = adapterLowongan
        rv_lowongan.layoutManager = LinearLayoutManager(this)

        adapterLowongan.setOnItemClickCallback(object : AdapterLowongan.OnItemClickCallback {
            override fun onItemClicked(bca: Bca) {
                showSelected(bca)
            }
        })

        val adapterKompetensi = AdapterKompetensi(list)
        rv_kompetensi.adapter = adapterKompetensi
        rv_kompetensi.layoutManager = LinearLayoutManager(this)

        adapterKompetensi.setOnItemClickCallback(object : AdapterKompetensi.OnItemClickCallback {
            override fun onItemClicked(bca: Bca) {
                showSelected(bca)
            }
        })
        val adapterMagang = AdapterMagang(list)
        rv_magang.adapter = adapterMagang
        rv_magang.layoutManager = LinearLayoutManager(this)

        adapterMagang.setOnItemClickCallback(object : AdapterMagang.OnItemClickCallback {
            override fun onItemClicked(bca: Bca) {
                showSelected(bca)
            }
        })
    }

    private fun showSelected(bca: Bca) {

        val intentDetail = Intent(this, DetailLowonganActivity::class.java)
        startActivity(intentDetail)

        Toast.makeText(this, "Kamu memilih " + bca.name, Toast.LENGTH_SHORT).show()
    }
}