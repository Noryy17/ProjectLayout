package com.example.projectlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardWidget(
    bgColor: Color,
    nama: String,
    telepon: String? = null,
    alamat: String,
    namaColor: Color,
    alamatColor: Color,
    teleponColor: Color? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        // WADAH MENYAMPING (Kiri ke Kanan)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // 1. ISI KIRI: Gambar Logo Pertama
            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )

            // 2. ISI TENGAH: Wadah Bersusun ke Bawah untuk Teks
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                // Teks Nama (Selalu Muncul)
                Text(
                    text = nama,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = namaColor,
                    fontFamily = FontFamily.Cursive
                )

                // Teks Telepon (Hanya muncul kalau datanya diisi)
                if (telepon != null && teleponColor != null) {
                    Text(
                        text = telepon,
                        fontSize = 12.sp,
                        color = teleponColor
                    )
                } // <-- Kurung tutup 'if' dipindah ke sini agar tidak menyandera alamat

                // Teks Alamat (Selalu Muncul di bawah Nama/Telepon)
                Text(
                    text = alamat,
                    fontSize = 12.sp,
                    color = alamatColor,
                    fontWeight = FontWeight.SemiBold
                )
            } // <-- Kurung tutup 'Column' dipindah ke sini karena urusan teks sudah selesai

            // 3. ISI KANAN: Gambar Logo Kedua (Sekarang sejajar dengan Logo Pertama & Column)
            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )

        } // <-- Kurung tutup 'Row'
    } // <-- Kurung tutup 'Card'
}