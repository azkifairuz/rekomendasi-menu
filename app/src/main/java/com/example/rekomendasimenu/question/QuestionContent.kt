package com.example.rekomendasimenu.question

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionContent(
    question: String = "",
    buyerSayYes: () -> Unit = {},
    buyerSayNo: () -> Unit = {},
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = question,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 20.sp
                    )

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(10.dp)
                            .clickable { buyerSayYes() },
                        elevation = CardDefaults.cardElevation(10.dp),
                    ) {
                        Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.Center) {
                            Text(text = "iya", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(10.dp)
                            .clickable { buyerSayNo() },
                        elevation = CardDefaults.cardElevation(10.dp),
                    ) {
                        Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.Center) {
                            Text(text = "tidak", style = MaterialTheme.typography.bodySmall)
                        }
                    }

                }


            }


        })
}
