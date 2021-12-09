package com.project01.siakad1.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project01.siakad1.R

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Chat"
    }
}