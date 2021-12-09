package com.project01.siakad1.ui.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.project01.siakad1.R
import kotlinx.android.synthetic.main.activity_choose_pembayaran.*
import kotlinx.android.synthetic.main.activity_keungan.*
import kotlinx.android.synthetic.main.activity_pembayaran.*

class ChoosePembayaranActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_pembayaran)
        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pilih Pembayaran"

        btn_next_pembayaran.setOnClickListener(this)
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
            R.id.btn_next_pembayaran -> {
                val nominalPembayaranActivity = Intent(this, NominalPembayaranActivity::class.java)
                startActivity(nominalPembayaranActivity)
            }
        }
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_dsp -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_spp -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                // TODO: Veggie sandwich
            }
        }
    }
}