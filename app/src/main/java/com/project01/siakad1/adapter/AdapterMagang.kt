package com.project01.siakad1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project01.siakad1.dummy.Bca
import com.project01.siakad1.R
import com.project01.siakad1.dummy.Pengumuman
import com.project01.siakad1.ui.potensi.DetailLowonganActivity
import com.project01.siakad1.ui.potensi.DetailMagangActivity

class AdapterMagang(private val arrayList: ArrayList<Bca>) : RecyclerView.Adapter<AdapterMagang.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    private lateinit var context: Context

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(bca: Bca)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_magang)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_deskripsi_magang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_magang, parent, false)
        context = parent.context
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val magang = arrayList[position]
        holder.tvName.text = magang.name
        holder.tvDetail.text = magang.detail

        holder.itemView.setOnClickListener {
            val intentDetailLow = Intent(context, DetailMagangActivity::class.java)
            intentDetailLow.putExtra(DetailMagangActivity.EXTRA_NAME, magang.name)
            intentDetailLow.putExtra(DetailMagangActivity.EXTRA_DETAIL, magang.detail)
            context.startActivity(intentDetailLow)
        }
    }

    override fun getItemCount(): Int = arrayList.size
}