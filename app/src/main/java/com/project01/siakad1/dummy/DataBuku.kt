package com.project01.siakad1.dummy

import com.project01.siakad1.R

object DataBuku {
    private val names = arrayOf("Pergi",
        "Pemimpi",
        "Pulang",
        "Habibie & Ainun")

    private val details = arrayOf(
        "Sebuah kisah tentang menemukan tujuan, ke mana hendak pergi, melalui kenangan demi kenangan masa lalu, pertarungan hidup-mati, untuk memutuskan ke mana langkah kaki akan dibawa.\n" +
                "\n" + "**Novel ini adalah naskah awal (asli) dari penulis; tanpa sentuhan editing, layout serta cover dari penerbit, dengan demikian, naskah ini berbeda dengan versi cetak, pun memiliki kelebihan dan kelemahan masing-masing.**",

        "Dalam novel Sang Pemimpi, Andrea Hirata bercerita tentang kehidupannya di Belitong pada masa SMA. Tiga tokoh utama dalam karya ini adalah Ikal, Arai dan Jimbron. Ikal tidak lain adalah Andrea Hirata sendiri, sedangkan Arai Ichsanul Mahidin adalah saudara jauhnya yang menjadi yatim piatu ketika masih kecil. Arai disebut simpai keramat karena dalam keluarganya ia adalah orang terakhir yang masih hidup dan ia pun diangkat menjadi anak oleh ayah Ikal. Jimbron merupakan teman Arai dan Ikal yang sangat terobsesi dengan kuda dan gagap bila sedang antusias terhadap sesuatu atau ketika gugup. Ketiganya melewati kisah persahabatan yang terjalin dari kecil hingga mereka bersekolah di SMA Negeri Bukan Main, SMA pertama yang berdiri di Belitung bagian timur.",

        "Sebuah kisah tentang menemukan tujuan, ke mana hendak pergi, melalui kenangan demi kenangan masa lalu, pertarungan hidup-mati, untuk memutuskan ke mana langkah kaki akan dibawa.",

        "Menceritakan berbagai kisah cinta menarik antara Pak Habibie dan Ibu Ainun. Mulai dari perjumpaan keduanya yang menjadi awal segalanya, keseharian dalam mengarungi bahtera rumah tangga hingga kejadian memilukan tatkala sang takdir Ilahi memisahkan keduanya. Selain itu para pembaca juga akan menemukan beberapa untaian doa dan puisi cinta yang pernah ditulis keduanya. Tak berlebihan jika Habibie mengatakan saat dirinya menulis buku ini tiap halamannya penuh dengan tetesan air mata. Menurutnya kehadiran Ainun yang telah mendampinginya selama ini, telah menjadi api yang selalu membakar energi semangat dan jiwanya dalam menjalani hidup. Sekaligus laksana air yang selalu menyiram dan meredakan gejolak jiwanya hingga kembali tenang."
    )

    private val images = intArrayOf(
        R.drawable.book_pergi,
        R.drawable.book_pemimpi,
        R.drawable.book_pulang,
        R.drawable.book_habibie_ainun
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