package com.cynthiawomentechsters.cynthianoteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cynthiawomentechsters.cynthianoteapp.Routes
import com.cynthiawomentechsters.cynthianoteapp.view_model.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(navController: NavController) {

   val noteViewModel: NoteViewModel = viewModel()
    var title by rememberSaveable { mutableStateOf(" ") }
    var content by rememberSaveable { mutableStateOf(" ")   }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Note", fontSize = 16.sp) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
//                navigationIcon = {
//                    IconButton(onClick =
//                    {
//                        //saves the Note
//                        noteViewModel.saveNote(title, content)
//                        //take the user back
//                        navController.popBackStack()
//                    }) {
//                        Icon(
//                            imageVector = Icons.Default.ArrowBack,
//                            contentDescription = "Back Button",
//                             //tint = Color.White
//
//                        )
//                    }
//                }
//            )
//        },
                //Tinus own
                actions = {
                    IconButton(onClick = {
                        noteViewModel.saveNote(title, content)
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Note Search"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More Icon"
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(all = 8.dp)
                    .fillMaxSize()
            ) {
                //Note app here
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = title,
                    onValueChange = { value -> title = value },
                    label = {Text("Task")},
                    )

                TextField(
                    value = content,
                    onValueChange = { value -> content = value },
                    label = {Text("Task Details")},
                    modifier = Modifier
                        .fillMaxWidth()
//                        .padding(bottom = 10.dp)
//                        .padding(top = 10.dp)
                )
            }
        }
    )
}
