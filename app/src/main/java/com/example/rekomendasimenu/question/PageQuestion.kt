package com.example.rekomendasimenu.question

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rekomendasimenu.route.Graph
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageQuestion(navHostController: NavHostController = rememberNavController(),supabaseClient: SupabaseClient) {

    Log.d("connectSb", "$supabaseClient")
    var questions = remember {
        mutableStateListOf<QuestionModel>()
    }
    var currentQuestion by remember {
        mutableStateOf(0)
    }
    val isQuestionsLoaded = remember { mutableStateOf(false) }
    val selectedAnswer = remember { mutableStateOf<Int?>(null) }
    LaunchedEffect(Unit) {
        Log.d("Supabase", "Fetching questions from Supabase...")
        try {
            val fetchedQuestions =
                supabaseClient.from("pertanyaan").select(columns = Columns.ALL).decodeList<QuestionModel>()
            questions.addAll(fetchedQuestions)
            Log.d("questionlist", "PageQuestion: $fetchedQuestions ")
            isQuestionsLoaded.value = true
        } catch (e: Exception) {
            // Tangani kesalahan
            Log.e("SupabaseError", "Failed to fetch questions: ${e.message}", e)
            // Atur isQuestionsLoaded ke false jika ada kesalahan
            isQuestionsLoaded.value = false
        }
    }
    suspend fun postResponse(kodePertanyaan: String) {
        val response = ResponseModel(
            id_pembeli = 1,
            kode_pertanyaan = kodePertanyaan
        )
        supabaseClient.from("response").insert(response)
    }

    suspend fun nextQuestion(answer: Number = 0) {

        if (currentQuestion != questions.size - 1) {
            if (answer == 1) {
                val currentCodeQuestion = questions[currentQuestion].kodePertanyaan
                postResponse(currentCodeQuestion)
                currentQuestion += 1
                return
            }
            if (answer == 0) {
                currentQuestion += 1
                return
            }
            return
        }

    }
    LaunchedEffect(selectedAnswer.value) {
        selectedAnswer.value?.let { answer ->
            nextQuestion(answer)
        }
    }





    Scaffold(modifier = Modifier.padding(horizontal = 20.dp), topBar = {
        IconButton(onClick = { navHostController.navigate(Graph.HOME) }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        }
    }) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (isQuestionsLoaded.value && questions.isNotEmpty()) {
                QuestionContent(
                    question = questions[currentQuestion].pertanyaan,
                    buyerSayYes = { selectedAnswer.value = 1 },
                    buyerSayNo = { selectedAnswer.value = 0 }
                )
            } else {
                Text(text = "....loading")
            }

        }

    }
}