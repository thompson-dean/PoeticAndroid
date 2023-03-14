package com.example.poetic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.poetic.navigation.Navigation
import com.example.poetic.ui.theme.PoeticTheme
import com.example.poetic.viewmodel.PoemViewModel

class MainActivity : ComponentActivity() {

    val poemViewModel by viewModels<PoemViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoeticTheme {
               Navigation(poemViewModel.randomPoems)
                poemViewModel.getRandomPoems()
            }
        }
    }
}
