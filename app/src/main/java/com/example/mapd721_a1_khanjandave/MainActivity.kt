package com.example.mapd721_a1_khanjandave

import android.annotation.SuppressLint
import android.os.Bundle
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mapd721_a1_khanjandave.ui.theme.MAPD721A1KhanjanDaveTheme
import com.example.mapd721_a1_khanjandave.ui.theme.darkGreen
import com.example.mapd721_a1_khanjandave.ui.theme.darkGrey
import com.example.mapd721_a1_khanjandave.ui.theme.darkRed
import com.example.mapd721_a1_khanjandave.ui.theme.darkYellow
import com.example.mapd721_a1_khanjandave.ui.theme.lightGreen
import com.example.mapd721_a1_khanjandave.ui.theme.lightGrey
import com.example.mapd721_a1_khanjandave.ui.theme.lightRed
import com.example.mapd721_a1_khanjandave.ui.theme.lightYellow

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(paddingValues: PaddingValues){
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }






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
                .height(45.dp),
            value = username,
            onValueChange = {username = it},
            placeholder = {
                Text(
                    text = "Username",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)
                ) },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray
            )

        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .height(45.dp),
            value = email,
            onValueChange = {email = it},
            placeholder = {
                Text(
                    text = "Email",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 10.dp)
                ) },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray
            )

        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .height(45.dp),
            value = id,
            onValueChange = {id = it},
            placeholder = {
                Text(
                    text = "Id",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 10.dp)
                ) },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray
            )

        )
        Row (
            modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            OutlinedButton(
                onClick = { },
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
                onClick = { },
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
                onClick = { },
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
                .background(color = lightGrey,
                    shape = RoundedCornerShape(10.dp))
                .border(BorderStroke(2.dp, darkGrey),
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
