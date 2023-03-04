package com.example.bmicalcapp

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import kotlin.math.pow

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
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
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
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    return text
}

@Composable
fun ShowBMIResult (bmi: Double) {
    Text(bmiResult(bmi))
}

fun mathematics (height: Double, weight: Double): Double {
    return weight / (height.pow(2))
}

fun bmiResult(bmi: Double): String {
    return if (bmi < 18.5) "Underweight"
    else if (bmi <= 25) "Normal weight"
    else if (bmi <= 30) "Overweight"
    else "Obese"
}