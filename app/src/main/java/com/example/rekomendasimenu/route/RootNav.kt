package com.example.rekomendasimenu.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rekomendasimenu.home.Home
import com.example.rekomendasimenu.question.PageQuestion
import io.github.jan.supabase.SupabaseClient

@Composable
fun RootNav(
    navController: NavHostController,
    supabaseClient: SupabaseClient,
) {
    NavHost(navController = navController, route = Graph.ROOT, startDestination = "route_home") {
        composable(Graph.HOME) {
            Home(navController)
        }
        composable(Graph.QUESTION) {
            PageQuestion(navController,supabaseClient)
        }

    }

}

object Graph {
    const val HOME = "route_home"
    const val ROOT = "root_graph"
    const val QUESTION = "question"
    const val RESULT = "hasil"



}