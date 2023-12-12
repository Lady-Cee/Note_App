package com.cynthiawomentechsters.cynthianoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cynthiawomentechsters.cynthianoteapp.screens.AddNoteScreen
import com.cynthiawomentechsters.cynthianoteapp.screens.NoteListScreen
import com.cynthiawomentechsters.cynthianoteapp.ui.theme.CynthiaNoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CynthiaNoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "note-list"
    ){
        composable("note-list"){
            NoteListScreen(navController)
        }
        composable("add-note"){
            AddNoteScreen()
        }
    }
}
//@Preview
//@Composable
//fun NoteListScreenPreview(){
//    Surface (
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background,
//    ){
//        NoteListScreen()
//    }
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginScreen(){
//    var username by remember{mutableStateOf(" ")}
//    var password by remember{mutableStateOf("")}
//    var fullname by remember{ mutableStateOf("") }
//    var confirmPassword by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf(" ") }
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.padding(all=8.dp)
//    ){
//        Text(
//            text = "Simple Login Page!",
//            fontSize = 20.sp,
//            textAlign = TextAlign.Center,
//        )
//        TextField(
//            value = fullname,
//            onValueChange = {typeName -> fullname = typeName},
//            label = {Text("Full Name")},
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//                .padding(top = 10.dp)
//            )
//        TextField(
//            value = username,
//            onValueChange = {usernameInput -> username = usernameInput},
//            label = {Text("Username")},
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//        )
//
//        TextField(
//            value = email,
//            onValueChange = {mailInput -> email = mailInput},
//            label = {Text("Email")},
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//        )
//        TextField(
//            value = password ,
//            onValueChange = {pwdInput -> password = pwdInput},
//            label = {Text("Password")},
//            visualTransformation = PasswordVisualTransformation(),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//        )
//        TextField(
//            value = confirmPassword ,
//            onValueChange = {confirmPwdInput -> confirmPassword = confirmPwdInput},
//            label = {Text("Confirm Password")},
//            visualTransformation = PasswordVisualTransformation(),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//        )
//        RememberMe()
//        Button(onClick = { }) {
//            Text(text = "Login")
//        }
//        Row{
//            Image(
//                painter = painterResource(id = R.drawable.google),
//                contentDescription = "Clickable facebook icon",
//                modifier = Modifier.size(24.dp)
//
//            )
//            Image(
//                painter = painterResource(id=R.drawable.facebook) ,
//                contentDescription = "Clickable Google Icon",
//                modifier = Modifier
//                    .size(24.dp)
//                    .clickable {
//                        //what happens when the image is tapped
//                    }
//            )
//        }
//
//    }
//}
//
//@Composable
//fun RememberMe(){
//    var isChecked by remember{ mutableStateOf(false) }
//
//    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.fillMaxWidth()
//    ){
//        Text(text = "Remember Me")
//        Switch(
//            checked = isChecked,
//            onCheckedChange = {isChecked = !isChecked}
//        )
//    }
//}
//
//@Composable
//fun NoteListScreen(){
//
//}
//@Preview
//@Composable
//fun LoginScreenPreview(){
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
//    ){
//        LoginScreen()
//    }
//}

