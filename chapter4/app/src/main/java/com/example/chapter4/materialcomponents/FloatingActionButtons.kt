package com.example.chapter4.materialcomponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TestFloatingActionButton() {
    FloatingActionButton(onClick = {}, content = {
        Icon(imageVector = Icons.Default.Add, contentDescription = "New Chat")
    })
}

@Composable
fun TestExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(onClick = {}, content = {
        Icon(imageVector = Icons.Default.Add, contentDescription = "New Chat")
        Text(modifier = Modifier.padding(10.dp), text = "New Chat")
    })
}
