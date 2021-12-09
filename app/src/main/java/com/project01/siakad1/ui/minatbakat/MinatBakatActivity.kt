package com.project01.siakad1.ui.minatbakat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.project01.siakad1.R
import com.project01.siakad1.databinding.ActivityMinatBakatBinding
import kotlinx.android.synthetic.main.activity_minat_bakat.*

class MinatBakatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMinatBakatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMinatBakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Minat Bakat"

        onClick()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun onClick() {
        binding.llTingkat1.setOnClickListener {
            AlertDialog.Builder(this).setTitle(getString(R.string.lanjutkanKeTesMinatBakat))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    val tingkat1 = Intent(this, TingkatActivity::class.java)
                    startActivity(tingkat1)
                }
                .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.llTingkat2.setOnClickListener {
            AlertDialog.Builder(this).setTitle(getString(R.string.lanjutkanKeTesMinatBakat))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    val tingkat1 = Intent(this, TingkatActivity::class.java)
                    startActivity(tingkat1)
                }
                .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.llTingkat3.setOnClickListener {
            AlertDialog.Builder(this).setTitle(getString(R.string.lanjutkanKeTesMinatBakat))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    val tingkat1 = Intent(this, TingkatActivity::class.java)
                    startActivity(tingkat1)
                }
                .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }


}