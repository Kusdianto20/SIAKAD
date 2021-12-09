package com.project01.siakad1.dummy

import com.project01.siakad1.R

object DataPengumuman {
    private val names = arrayOf("Ujian Tengah Semeter",
        "Ujian Semester Akhir",
        "Ujian Nasional",
        "Ujian Dadakan")

    private val details = arrayOf(
        "Berdasarkan Kalender Akademik SMA tentang Kegiatan Akademik Semester Genap TA 2020/2021 bahwa \"Pelaksanaan Ujian Tengah Semester (UTS) Genap TA 2020/2021 di Lingkungan SMA akan dilaksanakan pada tanggal 26 Novermber - 1 Desember 2021 dengan Mekanisme secara Daring\". Maka perlu disampaikan hal-hal sebagai berikut:\n" +
                "\n" + "Ujian Tengah Semester (UTS) Genap TA 2020/2021 dilaksanakan secara daring selama kurun waktu 26 April sampai 1 Mei 2021 dengan penjadwalan waktu UTS sesuai jadwal perkuliahan dan pelaksanaan UTS berlangsung pada pertemuan/Sesi ke-8.",
        "Berdasarkan Kalender Akademik SMA tentang Kegiatan Akademik Semester Genap TA 2020/2021 bahwa \"Pelaksanaan Ujian Tengah Semester (UTS) Genap TA 2020/2021 di Lingkungan SMA akan dilaksanakan pada tanggal 26 Novermber - 1 Desember 2021 dengan Mekanisme secara Daring\". Maka perlu disampaikan hal-hal sebagai berikut:\n" +
                "\n" + "Ujian Tengah Semester (UTS) Genap TA 2020/2021 dilaksanakan secara daring selama kurun waktu 26 April sampai 1 Mei 2021 dengan penjadwalan waktu UTS sesuai jadwal perkuliahan dan pelaksanaan UTS berlangsung pada pertemuan/Sesi ke-8.",
        "Berdasarkan Kalender Akademik SMA tentang Kegiatan Akademik Semester Genap TA 2020/2021 bahwa \"Pelaksanaan Ujian Tengah Semester (UTS) Genap TA 2020/2021 di Lingkungan SMA akan dilaksanakan pada tanggal 26 Novermber - 1 Desember 2021 dengan Mekanisme secara Daring\". Maka perlu disampaikan hal-hal sebagai berikut:\n" +
                "\n" + "Ujian Tengah Semester (UTS) Genap TA 2020/2021 dilaksanakan secara daring selama kurun waktu 26 April sampai 1 Mei 2021 dengan penjadwalan waktu UTS sesuai jadwal perkuliahan dan pelaksanaan UTS berlangsung pada pertemuan/Sesi ke-8.",
        "Berdasarkan Kalender Akademik SMA tentang Kegiatan Akademik Semester Genap TA 2020/2021 bahwa \"Pelaksanaan Ujian Tengah Semester (UTS) Genap TA 2020/2021 di Lingkungan SMA akan dilaksanakan pada tanggal 26 Novermber - 1 Desember 2021 dengan Mekanisme secara Daring\". Maka perlu disampaikan hal-hal sebagai berikut:\n" +
                "\n" + "Ujian Tengah Semester (UTS) Genap TA 2020/2021 dilaksanakan secara daring selama kurun waktu 26 April sampai 1 Mei 2021 dengan penjadwalan waktu UTS sesuai jadwal perkuliahan dan pelaksanaan UTS berlangsung pada pertemuan/Sesi ke-8."
    )

    private val images = intArrayOf(
        R.drawable.ic_example_pengumuman,
        R.drawable.ic_example_pengumuman,
        R.drawable.ic_example_pengumuman,
        R.drawable.ic_example_pengumuman
    )

    val listData: ArrayList<Pengumuman>
        get() {
            val list = arrayListOf<Pengumuman>()
            for (position in names.indices) {
                val pengumuman = Pengumuman()
                pengumuman.names = names[position]
                pengumuman.details = details[position]
                pengumuman.photos = images[position]
                list.add(pengumuman)
            }
            return list
        }
}