package com.example.bmicalcapp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.pow

@Composable
fun TextFieldValueScreen() {

    var weight by remember {mutableStateOf("")}
    var height by remember {mutableStateOf("")}
    var total by remember {mutableStateOf(0.0)}
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonTextField (
            title = "Weight",
            placeholder = "Insert your weight in Kilograms",
            text = weight,
            onValueChange = { weight = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        CommonTextField(
            title = "Height",
            placeholder = "Insert your height in meters",
            text = height,
            onValueChange = { height = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val weightDouble = weight.toDouble()
            val heightDouble = height.toDouble()

            if (height.isNotEmpty() && weight.isNotEmpty()) {
                total = mathematics(heightDouble, weightDouble)
            } else {
                Toast.makeText(
                    context,
                    "Please, insert both height and weight",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text(text = "Calculate")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (total != 0.0)
            Text(
                text = "Your BMI is $total",
                style = TextStyle (
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic,
                )
            )
    }
}

@Composable
fun CommonTextField(
    title: String,
    placeholder: String,
    text: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(text = title)
        },
        placeholder = {
            Text(text = placeholder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun TopAppBarUI () {
    TopAppBar(
        title = {Text("BMI Calculator")},
        elevation = 25.dp,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White
    )
}

fun mathematics (height: Double, weight: Double): Double {
    return weight / (height.pow(2))
}