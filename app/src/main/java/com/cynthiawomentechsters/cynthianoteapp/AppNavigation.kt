package com.cynthiawomentechsters.cynthianoteapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cynthiawomentechsters.cynthianoteapp.screens.AddNoteScreen
import com.cynthiawomentechsters.cynthianoteapp.screens.LoginScreen
import com.cynthiawomentechsters.cynthianoteapp.screens.NoteDetailsScreen
import com.cynthiawomentechsters.cynthianoteapp.screens.NoteListScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
       //startDestination = Routes.NoteListRoute
        startDestination = Routes.LoginRoute
      ){

        composable(Routes.NoteListRoute){
            NoteListScreen(navController)
        }
        composable(Routes.AddNoteRoute){
            AddNoteScreen(navController)
        }
        composable("note-details/{noteId}"){
            NoteDetailsScreen(
                navController = navController,
                noteId = it.arguments!!.getString("noteId")!!
            )
        }
        composable(Routes.LoginRoute){
            LoginScreen(navController)
        }
    }
}

object Routes{
    val NoteListRoute = "note-list"
    val AddNoteRoute = "add-note"
    fun NoteDetails(noteId: String): String{
       return "note-details/$noteId"
    }
    val LoginRoute = "log-in"
}