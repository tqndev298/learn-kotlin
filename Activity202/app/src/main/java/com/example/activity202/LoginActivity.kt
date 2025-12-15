package com.example.activity202

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val username = intent.getStringExtra(USERNAME_KEY)
        val password = intent.getStringExtra(PASSWORD_KEY)

        val loginResult = username == "username" && password == "password"
        val resultIntent = Intent().apply {
            putExtra(LOGIN_RESULT, loginResult)
        }
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}