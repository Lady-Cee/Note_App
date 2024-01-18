package com.cynthiawomentechsters.cynthianoteapp.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cynthiawomentechsters.cynthianoteapp.Routes
import com.cynthiawomentechsters.cynthianoteapp.models.Note
import java.time.Instant
import java.time.Instant.ofEpochMilli
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import androidx.compose.ui.Alignment.Companion as Alignment

//import androidx.annotation.RequiresApi

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteItem(note: Note, navController: NavController,  ) {
    val dismissState = rememberSwipeToDismissBoxState()
    val colorToBeShown by animateColorAsState(
        targetValue = if (dismissState.targetValue == SwipeToDismissBoxValue.EndToStart) {
            Color.Red
        } else {
            Color.White
        }
    )

//    var isDismissMode by remember { mutableStateOf(true) }
//    if (isDismissMode){
//        LaunchedEffect(key1 = "deleteItem"){
//       // call delete from here
//        }else{
//            LaunchedEffect(key1 = "resetItem" ){
//                dismissState.reset()
//            }
//        }
//    }

    val timeStamp = Instant.ofEpochMilli(note.dateTime)
    val dateTime = LocalDateTime.ofInstant(timeStamp, ZoneId.systemDefault())

    val formattedTime = dateTime.format(DateTimeFormatter.ofPattern("EEEE MMM. d, yyyy hh:mm a"))



    SwipeToDismissBox(state = dismissState,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorToBeShown)
                    .padding(horizontal = 8.dp)

            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(androidx.compose.ui.Alignment.CenterEnd)
                ) {
                    Text(text = "UNDO")
                }
            }
        }) {
        Card(

            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    navController.navigate(Routes.NoteDetails(note.id.toString()))
                })
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            ) {


                Text(
                    text = note.title,
                    fontWeight = FontWeight.Black,
                    maxLines = 3
                )
                Text(
                    text = note.content,
                    maxLines = 3
                )
                Text(
                    text = formattedTime,
                    color = Color.Blue,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.End)
                )

            }
        }
    }
}