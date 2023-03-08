package com.example.poetic.ui.theme.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.poetic.ui.theme.Garamond
import com.example.poetic.ui.theme.darkThemeColor

@Composable
fun Home() {
    Surface(modifier = Modifier
        .fillMaxSize()) {
        Column(modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.Start) {

            Text(text = "Poetic.",
            fontWeight = FontWeight.Bold,
            fontFamily = Garamond,
            fontSize = 48.sp,
            lineHeight = 30.sp)

            Text(text = "Discover Classical Poetry",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                color = darkThemeColor)

            Spacer(modifier = Modifier.padding(12.dp))

            Text(text = "Recommended",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 28.sp)

            Row() {
                (0..5).forEach {
                    HomeCard()
                }
            }

        }
    }
}

@Composable
fun HomeCard() {
Text("jazz")
}

@Preview
@Composable
fun Preview() {
    Home()
}