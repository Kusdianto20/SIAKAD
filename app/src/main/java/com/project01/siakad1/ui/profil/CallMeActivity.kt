package com.project01.siakad1.ui.profil

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.project01.siakad1.R
import com.project01.siakad1.databinding.ActivityCallMeBinding

class CallMeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCallMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallMeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Hubungi Kami"
    }

    private fun onClick() {
        binding.wa.setOnClickListener {
            AlertDialog.Builder(this).setTitle(getString(R.string.yakin))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://api.whatsapp.com/send?phone=6283162222688")
                    )
                    startActivity(i)
                }
                .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
            Toast.makeText(this, "Belum ada", Toast.LENGTH_SHORT).show()
        }

        binding.fb.setOnClickListener {
            AlertDialog.Builder(this).setTitle(getString(R.string.yakin))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/joy.juhanda")
                    )
                    startActivity(i)
                }
                .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.ig.setOnClickListener {
            AlertDialog.Builder(this).setTitle(getString(R.string.yakin))
                .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                    val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/juhanda.aja/?hl=en")
                    )
                    startActivity(i)
                }
                .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.web.setOnClickListener {
            Toast.makeText(this, "Belum ada", Toast.LENGTH_SHORT).show()
        }

        binding.telp.setOnClickListener {
            AlertDialog.Builder(this).setTitle(getString(R.string.yakin))
            .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                val phoneNumber = "083162222688"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
        }
    }
}