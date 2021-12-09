package com.project01.siakad1.adapter

import android.bluetooth.BluetoothDevice.EXTRA_NAME
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
import com.project01.siakad1.dummy.Bca
import com.project01.siakad1.ui.pengumuman.DetailPengumumanActivity
import com.project01.siakad1.ui.potensi.DetailLowonganActivity

class AdapterLowongan(private val arrayList: ArrayList<Bca>) : RecyclerView.Adapter<AdapterLowongan.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    private lateinit var context: Context

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(bca: Bca)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_perusahaan)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_deskripsi_perusahaan)
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_avatar_perusahaan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_lowongan, parent, false)
        context = parent.context
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val lowongan = arrayList[position]
        Glide.with(holder.itemView.context)
            .load(lowongan.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = lowongan.name
        holder.tvDetail.text = lowongan.detail

        holder.itemView.setOnClickListener {
            val intentDetailLow = Intent(context, DetailLowonganActivity::class.java)
            intentDetailLow.putExtra(DetailLowonganActivity.EXTRA_NAME, lowongan.name)
            intentDetailLow.putExtra(DetailLowonganActivity.EXTRA_DETAIL, lowongan.detail)
            intentDetailLow.putExtra(DetailLowonganActivity.EXTRA_PHOTO, lowongan.photo)
            context.startActivity(intentDetailLow)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}