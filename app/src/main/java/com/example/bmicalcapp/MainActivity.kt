package com.example.bmicalcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmicalcapp.ui.theme.BMICalcAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalcAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column (modifier = Modifier.padding(all = 10.dp)) {

                        val height = insertHeight()

                        Spacer(modifier = Modifier.height(8.dp))

                        val weight = insertWeight()
                    }
                }
            }
        }
    }
}

@Composable
fun insertHeight (): TextFieldValue {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text (text = "Height")
            },
            placeholder = {
                Text (text = "Insert your height in Meters")
            }
        )
    return text
}

@Composable
fun insertWeight (): TextFieldValue {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text (text = "Weight")
            },
            placeholder = {
                Text (text = "Insert your weight in Kilograms")
            }
        )
    return text
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMICalcAppTheme {
        Greeting("Android")
    }
}