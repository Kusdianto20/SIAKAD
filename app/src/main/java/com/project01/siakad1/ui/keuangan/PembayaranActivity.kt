package com.project01.siakad1.ui.keuangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.project01.siakad1.R
import kotlinx.android.synthetic.main.activity_pembayaran.*

class PembayaranActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pembayaran"

        btn_lakukan_pembayaran.setOnClickListener(this)
        tv_ubah_bank.setOnClickListener(this)

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
            R.id.btn_lakukan_pembayaran -> {
                AlertDialog.Builder(this).setTitle(getString(R.string.lakukanPembayaran))
                    .setPositiveButton(getString(R.string.yes)){dialog, _ ->

                        val lakukanPembayaran = Intent(this, KeuanganActivity::class.java)
                        startActivity(lakukanPembayaran)
                        Toast.makeText(this, "Pembayaran Telah Sukses!", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton(getString(R.string.no)){dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
            R.id.tv_ubah_bank -> {
                val chooseBankActivity = Intent(this, ChooseBankActivity::class.java)
                startActivity(chooseBankActivity)
            }

        }
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}