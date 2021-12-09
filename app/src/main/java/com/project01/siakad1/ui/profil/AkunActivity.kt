package com.project01.siakad1.ui.profil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project01.siakad1.R
import com.project01.siakad1.ui.profil.changepass.ChangePasswordActivity
import kotlinx.android.synthetic.main.activity_akun.*

class AkunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)

        btn_ubah_password.setOnClickListener{
            val changePasswordActivity = Intent(this, ChangePasswordActivity::class.java)
            startActivity(changePasswordActivity)
        }
        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Akun"
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}