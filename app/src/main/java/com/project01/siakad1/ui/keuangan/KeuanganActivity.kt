package com.project01.siakad1.ui.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.project01.siakad1.R
import kotlinx.android.synthetic.main.activity_choose_pembayaran.*
import kotlinx.android.synthetic.main.activity_keungan.*
import kotlinx.android.synthetic.main.activity_keungan.btn_pembayaran

class KeuanganActivity : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keungan)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Keuangan"

        btn_pembayaran.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_pembayaran -> {
                val choosePembayaranActivity = Intent(this, ChoosePembayaranActivity::class.java)
                startActivity(choosePembayaranActivity)
            }
        }
    }
}