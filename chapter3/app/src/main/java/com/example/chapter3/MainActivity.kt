package com.example.chapter3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var count by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "Counter: $count", style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
}

@Composable
fun Test(bookName: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Green),
        text = "Title of the book is: $bookName"
    )
}

//@Preview(showBackground = true)
@Composable
fun TestPreview() {
    Test("Android")
}

//@Preview(showBackground = true)
@Composable
fun TestColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Android")
        Text("Kotlin")
        Text("Compose")
    }
}

//@Preview(showBackground = true)
@Composable
fun TestRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("Android")
        Text("Kotlin")
        Text("Compose")
    }
}


//@Preview(showBackground = true)
@Composable
fun TestBox() {
    Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center) {
        Icon(
            modifier = Modifier.size(80.dp),
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.Green
        )
        Text("9")
    }
}

//@Preview(showBackground = true)
@Composable
fun TestListColumn() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        items(100) {
            Text(
                modifier = Modifier.padding(8.dp), text = "Item number $it"
            )
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun TestListRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        items(100) {
            Text(
                modifier = Modifier.padding(8.dp), text = "Item number $it"
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun TestListVerGrid() {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp),
        columns = GridCells.Fixed(3)
    ) {
        items(100) {
            Text(
                modifier = Modifier.padding(8.dp), text = "Item number $it"
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun TestListHorGrid() {
    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp),
        rows = GridCells.Fixed(3)
    ) {
        items(100) {
            Text(
                modifier = Modifier.padding(8.dp), text = "Item number $it"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestConstraintlayout() {
    ConstraintLayout(modifier = Modifier.padding(16.dp)) {
        val (icon, text) = createRefs()
        Icon(
            modifier = Modifier
                .size(80.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(
                        parent.start
                    )
                },
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.Green
        )
        Text(modifier = Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(icon.end)
        }, text = "9", style = MaterialTheme.typography.titleLarge)
    }
}