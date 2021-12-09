package com.project01.siakad1.ui.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.project01.siakad1.R
import kotlinx.android.synthetic.main.activity_nominal_pembayaran.*
import kotlinx.android.synthetic.main.activity_pembayaran.*

class NominalPembayaranActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nominal_pembayaran)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Nominal Pembayaran"

        btn_checkout.setOnClickListener(this)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_checkout -> {
                val pembayaranActivity = Intent(this, PembayaranActivity::class.java)
                startActivity(pembayaranActivity)
            }
        }
    }
}