package com.example.rekomendasimenu.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rekomendasimenu.route.Graph

@Composable
fun Home(navHostController: NavHostController = rememberNavController()) {
    var scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(horizontal = 25.dp, vertical = 20.dp)
            .verticalScroll(scrollState),
    ) {
        Text(text = "Rekomendasi Menu", style = MaterialTheme.typography.titleMedium, fontSize = 30.sp)
        Text(
            text = "Mengenal diri Lebih dalam",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "subtitle", style = MaterialTheme.typography.bodySmall)
        Button(
            modifier = Modifier
                .width(150.dp)
                .padding(vertical = 10.dp),
            onClick = { navHostController.navigate(Graph.QUESTION)},
            shape = RoundedCornerShape(50),
        ) {
            Text(text = "Mulai", style = MaterialTheme.typography.titleMedium)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Baca Panduan Pengisiannya, yuk!",
            style = MaterialTheme.typography.headlineSmall,
            fontSize = 18.sp
        )
        Column(modifier = Modifier.padding(start = 15.dp)) {

            Text(
                text = "1. Gak ada jawaban yang benar atau salah, isilah dengan jujur sesuai kepribaanmu",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "2. Santai aja, tes ini gak diberi waktu",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "3. Cari tempat yang nyaman dan kondusif supaya kamu lebih fokus",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "4. Jika kamu Keluar di tengah jalan, maka seluruh proses tes dan jawaban akan hilang",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "5. Hasil tes bisa kamu dapatkan setelah mengisi semua pertanyaan dengan lengkap",
                style = MaterialTheme.typography.bodyMedium
            )

        }

    }
}

@Preview
@Composable
fun PreviewHome() {
    Home()
}