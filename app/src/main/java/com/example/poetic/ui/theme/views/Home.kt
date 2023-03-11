package com.example.poetic.ui.theme.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Column(horizontalAlignment = Alignment.Start) {

            Text(text = "Poetic.",
            fontWeight = FontWeight.Bold,
            fontFamily = Garamond,
            fontSize = 48.sp,
            lineHeight = 30.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp))

            Text(text = "Discover Classical Poetry",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                color = darkThemeColor,
                modifier = Modifier
                    .padding(horizontal = 16.dp))

            Spacer(modifier = Modifier.padding(8.dp))

            Text(text = "Recommended",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp))

            Spacer(modifier = Modifier.padding(4.dp))

            val list = listOf(0, 1, 2, 3, 4, 5)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    (0..5).forEach { index ->
                        HomeCard()
                    }
                }

            }

        }
    }
}

@Composable
fun HomeCard() {
    Card(modifier = Modifier
        .padding(8.dp)
        .width(260.dp),
        backgroundColor = Color.Black
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "William Shakespeare",
            fontWeight = FontWeight.SemiBold
            )

            Text(text = "Where be thee?")

            Text(text = "...",
            fontWeight = FontWeight.Bold)

            Text(
                text = "Sonnet 1",
                fontWeight = FontWeight.SemiBold,
                color = darkThemeColor)
        }

}

}

@Preview
@Composable
fun Preview() {
    Home()
}