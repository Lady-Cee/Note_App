package com.cynthiawomentechsters.cynthianoteapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cynthiawomentechsters.cynthianoteapp.Routes
import com.cynthiawomentechsters.cynthianoteapp.models.Note

@Composable
fun NoteItem(notes: Note, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {  navController.navigate(Routes.NoteDetails)}
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Text(text = notes.title, fontWeight = FontWeight.Black)
            Text( text = notes.content )
            Text(text = "11:00 PM", color = Color.Red, fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.End))
        }
    }
}