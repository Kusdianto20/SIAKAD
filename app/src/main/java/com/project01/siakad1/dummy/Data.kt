package com.project01.siakad1.dummy

import com.project01.siakad1.R

object Data {
    private val names = arrayOf("Ahmad BCA",
        "Yani Google",
        "Tanu Microsoft")

    private val details = arrayOf("PT Bank Central Asia Tbk adalah bank swasta terbesar di Indonesia. Bank ini didirikan pada 21 Februari 1957 dengan nama Bank Central Asia NV dan pernah menjadi bagian penting dari Salim Group. Sekarang bank ini dimiliki oleh salah satu grup produsen rokok terbesar keempat di Indonesia, Djarum. ",
        "PT Bank Central Asia Tbk adalah bank swasta terbesar di Indonesia. Bank ini didirikan pada 21 Februari 1957 dengan nama Bank Central Asia NV dan pernah menjadi bagian penting dari Salim Group. Sekarang bank ini dimiliki oleh salah satu grup produsen rokok terbesar keempat di Indonesia, Djarum. ",
        "PT Bank Central Asia Tbk adalah bank swasta terbesar di Indonesia. Bank ini didirikan pada 21 Februari 1957 dengan nama Bank Central Asia NV dan pernah menjadi bagian penting dari Salim Group. Sekarang bank ini dimiliki oleh salah satu grup produsen rokok terbesar keempat di Indonesia, Djarum. ")

    private val images = intArrayOf(
        R.drawable.ic_example_lowongan,
        R.drawable.ic_example_lowongan,
        R.drawable.ic_example_lowongan)

    val listData: ArrayList<Bca>
        get() {
            val list = arrayListOf<Bca>()
            for (position in names.indices) {
                val perusahaan = Bca()
                perusahaan.name = names[position]
                perusahaan.detail = details[position]
                perusahaan.photo = images[position]
                list.add(perusahaan)
            }
            return list
        }
}