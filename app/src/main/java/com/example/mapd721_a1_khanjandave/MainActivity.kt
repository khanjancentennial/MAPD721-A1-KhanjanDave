package com.example.mapd721_a1_khanjandave

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mapd721_a1_khanjandave.ui.theme.MAPD721A1KhanjanDaveTheme
import com.example.mapd721_a1_khanjandave.ui.theme.darkBlue
import com.example.mapd721_a1_khanjandave.ui.theme.darkGreen
import com.example.mapd721_a1_khanjandave.ui.theme.darkGrey
import com.example.mapd721_a1_khanjandave.ui.theme.darkRed
import com.example.mapd721_a1_khanjandave.ui.theme.darkYellow
import com.example.mapd721_a1_khanjandave.ui.theme.lightBlue
import com.example.mapd721_a1_khanjandave.ui.theme.lightGreen
import com.example.mapd721_a1_khanjandave.ui.theme.lightGrey
import com.example.mapd721_a1_khanjandave.ui.theme.lightRed
import com.example.mapd721_a1_khanjandave.ui.theme.lightYellow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721A1KhanjanDaveTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Greeting()
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Assignment 1",
                    textAlign = TextAlign.Center,
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Cyan
            ),

        )
    },
        content = {innerPadding->
            Body(innerPadding)
        },
    )

}

// body function with all the design
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Body(paddingValues: PaddingValues){

    // context
    val context = LocalContext.current

    // scope
    val scope = rememberCoroutineScope()

    // datastore class access using variable
    val dataStore = StoreData(context)

    // get saved username, email and id
    val savedUsernameState = dataStore.getUsername.collectAsState(initial = "")
    val savedEmailState = dataStore.getEmail.collectAsState(initial = "")
    val savedIdState = dataStore.getId.collectAsState(initial = "")

    // declare variable using remember to store the state
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }

    // manage cursor focus
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    // design
    Column (
        modifier =
        Modifier
            .fillMaxSize()
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = 50.dp,
                start = 20.dp, end = 20.dp
            )
    ){
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .height(50.dp)
                .focusRequester(focusRequester),
            value = username,
            onValueChange = {username = it},
            placeholder = {
                Text(
                    text = "Username",
                    fontSize = 14.sp,
                    modifier = Modifier
                ) },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                // display color based on value
                containerColor = if (username == savedUsernameState.value && savedUsernameState.value!!.isNotEmpty()) lightBlue else lightGrey,
                focusedBorderColor = if (username.isNotEmpty()) darkBlue else darkGrey,
                unfocusedBorderColor = if (username.isNotEmpty()) darkBlue else darkGrey


            )

        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .height(50.dp)
                .focusRequester(focusRequester),
            value = email,
            onValueChange = {email = it},
            placeholder = {
                Text(
                    text = "Email",
                    fontSize = 14.sp,
                ) },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                // display color based on value
                containerColor = if (email == savedEmailState.value && savedEmailState.value!!.isNotEmpty()) lightBlue else lightGrey,
                focusedBorderColor = if (email.isNotEmpty()) darkBlue else darkGrey,
                unfocusedBorderColor = if (email.isNotEmpty()) darkBlue else darkGrey


            ),

        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .height(50.dp)
                .focusRequester(focusRequester),
            value = id,

            onValueChange = {id = it},
            placeholder = {
                Text(
                    text = "Id",
                    fontSize = 14.sp,
                ) },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                // display color based on value
                containerColor = if (id == savedIdState.value && savedIdState.value!!.isNotEmpty()) lightBlue else lightGrey,
                focusedBorderColor = if (id.isNotEmpty()) darkBlue else darkGrey,
                unfocusedBorderColor = if (id.isNotEmpty()) darkBlue else darkGrey,
            )

        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            OutlinedButton(
                onClick = {
                    // manage button click based on value and load data in text field
                    if(savedUsernameState.value!!.isEmpty() && savedEmailState.value!!.isEmpty() && savedIdState.value!!.isEmpty()){
                        Toast.makeText(context,"Values not found",Toast.LENGTH_SHORT).show()
                    }else{
                        username = savedUsernameState.value ?: ""
                        email = savedEmailState.value ?: ""
                        id = savedIdState.value ?: ""
                    }

                    focusManager.clearFocus()

                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = lightYellow
                ),
                border = BorderStroke(2.dp, darkYellow)

            ) {
                Row{
                    Text(text = "Load")
                }

            }

            OutlinedButton(
                onClick = {
                    // manage save button and store data into data store
                    if (username.isNotEmpty() && email.isNotEmpty() && id.isNotEmpty()){
                        scope.launch {
                            dataStore.saveData(username, email, id)
                            username = ""
                            email = ""
                            id = ""
                        }
                        Toast.makeText(context,"Data saved successfully",Toast.LENGTH_SHORT).show()
                        focusManager.clearFocus()
                    }else{
                        Toast.makeText(context,"Please fill all the details",Toast.LENGTH_SHORT).show()
                    }

                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = lightGreen
                ),
                border = BorderStroke(2.dp, darkGreen)

            ) {
                Row{
                    Text(text = "Save")
                }

            }

            OutlinedButton(
                onClick = {
                    // manage clear data button and clear the data from data store
                    scope.launch {
                        dataStore.clearData()
                        username = ""
                        email = ""
                        id = ""
                    }

                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = lightRed,

                ),
                border = BorderStroke(2.dp, darkRed)

            ) {
                Row{
                    Text(text = "Clear")
                }

            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .background(
                    color = lightGrey,
                    shape = RoundedCornerShape(10.dp)
                )
                .border(
                    BorderStroke(2.dp, darkGrey),
                    shape = RoundedCornerShape(10.dp)
                ),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                color = Color.Blue,
                text = "Khanjan Dave \n301307330 ",
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MAPD721A1KhanjanDaveTheme {
        Greeting()
    }
}
