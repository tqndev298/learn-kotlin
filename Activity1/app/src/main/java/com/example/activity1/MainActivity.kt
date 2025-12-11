package com.example.activity1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.activity1.ui.theme.Activity1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Activity1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        Text("RGB Color Creator", fontSize = 24.sp)
                        Text("Add two hexadecimal characters between 0-9, A-F or a-f without the '#' for each channel")

                        var redChanel by remember { mutableStateOf("") }
                        var greenChanel by remember { mutableStateOf("") }
                        var blueChanel by remember { mutableStateOf("") }
                        var colorToDisplay by remember { mutableStateOf(Color.White) }

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = redChanel,
                            onValueChange = { redChanel = it },
                            label = { Text("Red chanel") })

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = greenChanel,
                            onValueChange = { greenChanel = it },
                            label = { Text("Green chanel") })

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = blueChanel,
                            onValueChange = { blueChanel = it },
                            label = { Text("Blue chanel") })

                        Button(modifier = Modifier.fillMaxWidth(), onClick = {
                            if (isValidHexInput(redChanel) && isValidHexInput(greenChanel) && isValidHexInput(
                                    blueChanel
                                )
                            ) {
                                val colorString = "#$redChanel$greenChanel$blueChanel"
                                colorToDisplay = Color(colorString.toColorInt())

                            }
                        }) {
                            Text("Create RGB Color")
                        }

                        Text(
                            "Created color display panel",
                            modifier = Modifier
                                .background(colorToDisplay)
                                .padding(24.dp)
                        )
                    }
                }
            }
        }
    }
}

fun isValidHexInput(input: String): Boolean {
    return input.filter {
        it in '0'..'9' || it in 'A'..'F' || it in 'a'..'f'
    }.length == 2
}

