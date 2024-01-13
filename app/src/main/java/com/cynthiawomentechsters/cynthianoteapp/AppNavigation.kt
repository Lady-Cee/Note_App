package com.cynthiawomentechsters.cynthianoteapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cynthiawomentechsters.cynthianoteapp.screens.AddNoteScreen
import com.cynthiawomentechsters.cynthianoteapp.screens.NoteDetailsScreen
import com.cynthiawomentechsters.cynthianoteapp.screens.NoteListScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.NoteListRoute
    ){
        composable(Routes.NoteListRoute){
            NoteListScreen(navController)
        }
        composable(Routes.AddNoteRoute){
            AddNoteScreen(navController)
        }
        composable(Routes.NoteDetails){
            NoteDetailsScreen(navController = navController)
        }
    }
}

object Routes{
    val NoteListRoute = "note-list"
    val AddNoteRoute = "add-note"
    val NoteDetails = "note-details"
}