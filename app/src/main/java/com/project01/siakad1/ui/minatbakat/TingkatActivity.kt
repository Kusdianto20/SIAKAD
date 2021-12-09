package com.project01.siakad1.ui.minatbakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.project01.siakad1.R
import kotlinx.android.synthetic.main.activity_minat_bakat.*

class TingkatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tingkat)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Minat Bakat"

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {

            val checked = view.isChecked
            when (view.getId()) {
                R.id.A ->
                    if (checked) {
                        // Pirates are the best
                    }
                R.id.B ->
                    if (checked) {
                        // Ninjas rule
                    }
            }
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