package com.project01.siakad1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project01.siakad1.dummy.DataPengumuman
import com.project01.siakad1.dummy.Pengumuman
import com.project01.siakad1.adapter.AdapterPengumuman
import com.project01.siakad1.chat.ChatActivity
import com.project01.siakad1.menu.MenuList
import com.project01.siakad1.notification.NotificationActivity
import com.project01.siakad1.ui.JadwalActivity
import com.project01.siakad1.ui.pengumuman.PengumumanActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvLowongnan: RecyclerView
    private var list: ArrayList<Pengumuman> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvListConfig()
        list.addAll(DataPengumuman.listData)

        btn_list_home.setOnClickListener(this)
        tv_lihat_jadwal.setOnClickListener(this)
        tv_lihat_pengumuman.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater= menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun rvListConfig() {
        val adapterPengumuman =  AdapterPengumuman(list)
        rv_pengumuman.adapter = adapterPengumuman
        rv_pengumuman.layoutManager = LinearLayoutManager(this)

        adapterPengumuman.setOnItemClickCallback(object : AdapterPengumuman.OnItemClickCallback {
            override fun onItemClicked(pengumuman: Pengumuman) {
                showSelectedHero(pengumuman)
            }
        })
    }

    private fun showSelectedHero(pengumuman: Pengumuman) {
        Toast.makeText(this, "Kamu memilih " + pengumuman.names, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_chat -> {
                val actionChat = Intent(this, ChatActivity::class.java)
                startActivity(actionChat)
                true
            }
            R.id.action_notif -> {
                val actionNotif = Intent(this, NotificationActivity::class.java)
                startActivity(actionNotif)
                true
            }
            else -> true
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_list_home -> {
                val listHome = Intent(this, MenuList::class.java)
                startActivity(listHome)
            }
            R.id.tv_lihat_jadwal -> {
                val jadwalActivity = Intent(this, JadwalActivity::class.java)
                startActivity(jadwalActivity)
            }
            R.id.tv_lihat_pengumuman -> {
                val pengumumanActivity = Intent(this, PengumumanActivity::class.java)
                startActivity(pengumumanActivity)
            }
        }
    }

}