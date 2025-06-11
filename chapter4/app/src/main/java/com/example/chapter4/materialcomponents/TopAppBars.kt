package com.example.chapter4.materialcomponents

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestTopAppBar() {
    TopAppBar(title = {
        Text("Test Publishing")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestCenterAlignedTopBar() {
    CenterAlignedTopAppBar(title = {
        Text("Test Publishing")
    })
}