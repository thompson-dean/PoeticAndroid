package com.example.poetic.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.poetic.model.Datasource
import com.example.poetic.model.Poem
import com.example.poetic.ui.theme.Garamond

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
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(horizontal = 16.dp))

            Spacer(modifier = Modifier.padding(8.dp))

            Text(text = "Recommended",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp))

            Spacer(modifier = Modifier.padding(2.dp))
            
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    (0..5).forEach { index ->
                        HomeCard(poem = Datasource().mockPoem)
                    }
                }

            }

            Text(text = "Recent",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp))

            Spacer(modifier = Modifier.padding(2.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    (0..14).forEach { index ->
                        PoemListCard(poem = Datasource().mockPoem)
                    }
                }
            }

        }
    }
}

@Composable
fun HomeCard(poem: Poem) {
    Card(modifier = Modifier
        .padding(8.dp)
        .width(260.dp)
        .height(176.dp)
        .clickable { },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = poem.author,
            fontWeight = FontWeight.SemiBold
            )

            Text(text = poem.lines[0])

            Text(text = "...",
            fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = poem.title,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.primary)
        }

    }
}

@Composable
fun PoemListCard(poem: Poem) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable { },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
            AuthorTitleColumn(poem = poem)

            Icon(imageVector = Icons.Default.ChevronRight, contentDescription = "Right Chevron")
        }
    }

}

@Composable
fun AuthorTitleColumn(poem: Poem) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(0.9f),
            horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = poem.author,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "2023/05/23",
                color = Color.LightGray,
                fontSize = 12.sp
            )

        }
        Text(
            text = poem.title,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.primary
        )
    }
}

@Preview
@Composable
fun Preview() {
    Home()
}