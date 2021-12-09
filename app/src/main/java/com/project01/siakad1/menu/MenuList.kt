package com.project01.siakad1.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.project01.siakad1.R
import com.project01.siakad1.ui.*
import com.project01.siakad1.ui.keuangan.KeuanganActivity
import com.project01.siakad1.ui.minatbakat.MinatBakatActivity
import com.project01.siakad1.ui.perpustakaan.PerputakaanActivity
import com.project01.siakad1.ui.potensi.PotensiActivity
import com.project01.siakad1.ui.profil.ProfilActivity
import com.project01.siakad1.ui.tugas.TugasActivity
import kotlinx.android.synthetic.main.activity_menu_list.*

class MenuList : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Menu"

        btn_keuangan_menu.setOnClickListener(this)
        btn_jadwal.setOnClickListener(this)
        btn_nilai.setOnClickListener(this)
        btn_tugas.setOnClickListener(this)
        btn_absensi.setOnClickListener(this)
        btn_perpus.setOnClickListener(this)
        btn_minat_bakat.setOnClickListener(this)
        btn_kompetensi.setOnClickListener(this)
        btn_profil.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_keuangan_menu -> {
                val keuanganActivity = Intent(this, KeuanganActivity::class.java)
                startActivity(keuanganActivity)
            }
            R.id.btn_jadwal -> {
                val jadwalActivity = Intent(this, JadwalActivity::class.java)
                startActivity(jadwalActivity)
            }
            R.id.btn_nilai -> {
                val nilaiActivity = Intent(this, NilaiActivity::class.java)
                startActivity(nilaiActivity)
            }
            R.id.btn_tugas -> {
                val tugasActivity = Intent(this, TugasActivity::class.java)
                startActivity(tugasActivity)
            }
            R.id.btn_absensi -> {
                val absensiActivity = Intent(this, AbsensiActivity::class.java)
                startActivity(absensiActivity)
            }
            R.id.btn_perpus -> {
                val perputakaanActivity = Intent(this, PerputakaanActivity::class.java)
                startActivity(perputakaanActivity)
            }
            R.id.btn_minat_bakat -> {
                val minatBakatActivity = Intent(this, MinatBakatActivity::class.java)
                startActivity(minatBakatActivity)
            }
            R.id.btn_kompetensi -> {
                val kompetensiActivity = Intent(this, PotensiActivity::class.java)
                startActivity(kompetensiActivity)
            }
            R.id.btn_profil -> {
                val profilAbsensiActivity = Intent(this, ProfilActivity::class.java)
                startActivity(profilAbsensiActivity)
            }
        }
    }
}