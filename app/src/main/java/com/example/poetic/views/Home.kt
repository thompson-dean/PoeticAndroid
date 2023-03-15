package com.example.poetic.views

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.poetic.model.Datasource
import com.example.poetic.model.Poem
import com.example.poetic.navigation.DetailNavItem
import com.example.poetic.ui.theme.Garamond
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.poetic.viewmodel.HomeUiState
import com.example.poetic.viewmodel.PoemViewModel

@Composable
fun Home(navController: NavController, viewModel: PoemViewModel = viewModel()) {

    val homeUiState by viewModel.uiState.collectAsState()

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
                items(homeUiState.randomPoems) {poem ->
                        HomeCard(
                            poem = poem,
                            completion = {
                            navController.navigate(
                                route = DetailNavItem.Detail.route + "/" + poem.title)
                        })
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
                        PoemListCard(poem = Datasource().mockPoem, completion = {
                            navController.navigate(route = DetailNavItem.Detail.route)
                        })
                    }
                }
            }

        }
    }
}

@Composable
fun HomeCard(poem: Poem, completion: () -> Unit) {
    Card(modifier = Modifier
        .padding(8.dp)
        .width(260.dp)
        .height(176.dp)
        .clickable { completion() },
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

            if (poem.lines[0].trim().isEmpty() || poem.lines[0].length < 8) {
                if (poem.lines[1].trim().isEmpty() || poem.lines[1].length < 8) {
                    Text(text = poem.lines[2],
                        maxLines = 3)
                } else {
                    Text(text = poem.lines[1],
                        maxLines = 3)
                }
            } else {
                Text(text = poem.lines[0],
                    maxLines = 3)
            }


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
fun PoemListCard(poem: Poem, completion: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable { completion() },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

            AuthorTitleColumn(poem = poem)

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Right Chevron",
                tint = MaterialTheme.colors.onSurface
                )
        }
    }
}

@Composable
fun AuthorTitleColumn(poem: Poem) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
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
            modifier = Modifier.fillMaxWidth(0.9f),
            text = poem.title,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.primary
        )
    }
}
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun Preview() {
//    Home()
}