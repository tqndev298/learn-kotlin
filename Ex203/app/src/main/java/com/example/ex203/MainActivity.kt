package com.example.ex203

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ex203.ui.theme.Ex203Theme
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ex203Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)

                    ) {
                        val context = LocalContext.current
                        var firstName by rememberSaveable { mutableStateOf("") }
                        var lastName by rememberSaveable { mutableStateOf("") }
                        var fullName by rememberSaveable { mutableStateOf("") }

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = firstName,
                            onValueChange = { firstName = it },
                            label = { Text("First Name") })

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = lastName,
                            onValueChange = { lastName = it },
                            label = { Text("Last Name") })

                        Button(modifier = Modifier.fillMaxWidth(), onClick = {

                            if (firstName.isNotBlank() && lastName.isNotBlank()) fullName =
                                "$firstName $lastName"
                            else {
                                fullName = ""
                                var toast = Toast.makeText(
                                    context, "Please enter your name", Toast.LENGTH_LONG
                                )
                                toast.setGravity(Gravity.CENTER, 0, 0)
                                toast.show()
                            }
                        }) {
                            Text("Enter")
                        }
                        if (fullName.isNotBlank()) {
                            Text("Welcome to $fullName")
                        }
                    }
                }
            }
        }
    }
}

