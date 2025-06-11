package com.example.chapter4.materialcomponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.chapter4.ui.theme.Chapter4Theme

@Composable
fun TestBottomAppBar() {
    BottomAppBar(actions = {
        Icon(imageVector = Icons.Rounded.Home, contentDescription = "Home Screen")
        Icon(imageVector = Icons.Rounded.ShoppingCart, contentDescription = "Cart Screen")
        Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "Account Screen")
    }, floatingActionButton = { TestFloatingActionButton() })
}

@Preview
@Composable
fun TestBottomAppBarPreview() {
    Chapter4Theme {
        TestBottomAppBar()
    }
}