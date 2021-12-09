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
import com.project01.siakad1.ui.potensi.DetailKompetensiActivity
import com.project01.siakad1.ui.potensi.DetailMagangActivity

class AdapterKompetensi(private val arrayList: ArrayList<Bca>) : RecyclerView.Adapter<AdapterKompetensi.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    private lateinit var context: Context

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(bca: Bca)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_kompetensi)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_deskripsi_kompetensi)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kompetensi, parent, false)
        context = parent.context
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val kompetensi = arrayList[position]
        holder.tvName.text = kompetensi.name
        holder.tvDetail.text = kompetensi.detail

        holder.itemView.setOnClickListener {
            val intentDetailLow = Intent(context, DetailKompetensiActivity::class.java)
            intentDetailLow.putExtra(DetailKompetensiActivity.EXTRA_NAME, kompetensi.name)
            intentDetailLow.putExtra(DetailKompetensiActivity.EXTRA_DETAIL, kompetensi.detail)
            context.startActivity(intentDetailLow)
        }
    }

    override fun getItemCount(): Int = arrayList.size
}