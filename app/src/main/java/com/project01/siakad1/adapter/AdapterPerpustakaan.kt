package com.project01.siakad1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project01.siakad1.R
import com.project01.siakad1.dummy.Pengumuman
import com.project01.siakad1.ui.perpustakaan.DetailPerpustakaanActivity

class AdapterPerpustakaan (private val arrayList: ArrayList<Pengumuman>) : RecyclerView.Adapter<AdapterPerpustakaan.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    private lateinit var context: Context

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(pengumuman: Pengumuman)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_buku)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_deskripsi_buku)
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_avatar_buku)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_perpus, parent, false)
        context = parent.context
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pengumuman = arrayList[position]

        holder.tvName.text = pengumuman.names
        holder.tvDetail.text = pengumuman.details
        Glide.with(holder.itemView.context)
            .load(pengumuman.photos)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener {
            //onItemClickCallback?.onItemClicked(arrayList[holder.adapterPosition])

            val intentDetail = Intent(context, DetailPerpustakaanActivity::class.java)
            intentDetail.putExtra(DetailPerpustakaanActivity.EXTRA_DATA, pengumuman.names)
            intentDetail.putExtra(DetailPerpustakaanActivity.EXTRA_DATA2, pengumuman.details)
            intentDetail.putExtra(DetailPerpustakaanActivity.EXTRA_DATA3, pengumuman.photos)
            context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = arrayList.size
}