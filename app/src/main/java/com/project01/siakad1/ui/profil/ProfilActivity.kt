package com.project01.siakad1.ui.profil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.project01.siakad1.R
import com.project01.siakad1.databinding.ActivityProfilBinding
import com.project01.siakad1.ui.login.LoginActivity

class ProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilBinding
    val TAG = "ProfilActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate")

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Profil"

        onClick()

    }

    private fun onClick() {
        binding.btnAkun.setOnClickListener{
            val akunActivity = Intent(this, AkunActivity::class.java)
            startActivity(akunActivity)
        }
        binding.btnDataDiri.setOnClickListener{
            val dataDiriActivity = Intent(this, DataDiriActivity::class.java)
            startActivity(dataDiriActivity)
        }
        binding.btnFAQ.setOnClickListener{
            val faqActivity = Intent(this, FAQActivity::class.java)
            startActivity(faqActivity)
        }
        binding.btnSyaratKetentuan.setOnClickListener{
            val syaratdanKetentuanActivity = Intent(this, SyaratdanKetentuanActivity::class.java)
            startActivity(syaratdanKetentuanActivity)
        }
        binding.btnHubungiKami.setOnClickListener {
            val callMeActivity = Intent(this, CallMeActivity::class.java)
            startActivity(callMeActivity)
        }
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this).setTitle(getString(R.string.are_you_sure_to_logout))
                .setPositiveButton(getString(R.string.yes)){dialog, _ ->
                    val mainActivity = Intent(this, LoginActivity::class.java)
                    startActivity(mainActivity)

                }
                .setNegativeButton(getString(R.string.no)){dialog, _ ->
                    dialog.dismiss()
                }
                .show()
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