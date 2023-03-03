package com.example.bmicalcapp

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import kotlin.math.pow

@Composable
fun insertHeight (): Double {
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
    return text.toString().toDouble()
}

@Composable
fun insertWeight (): Double {
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
    return text.toString().toDouble()
}

fun mathematics (height: Double, weight: Double): Double {
    return weight / (height.pow(2))
}

