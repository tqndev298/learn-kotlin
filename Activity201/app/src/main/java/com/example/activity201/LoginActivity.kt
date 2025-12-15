package com.example.activity201

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activity201.ui.theme.Activity201Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val username = intent.getStringExtra(USERNAME_KEY)
        val password = intent.getStringExtra(PASSWORD_KEY)

        setContent {
            Activity201Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val message = if (username == "username" && password == "password") {
                        "Welcome $username"
                    } else {
                        "Login failed. Please try again"
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Text(text = message, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}