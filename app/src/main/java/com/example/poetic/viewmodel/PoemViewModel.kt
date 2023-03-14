package com.example.poetic.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poetic.model.Poem
import com.example.poetic.network.ApiService
import kotlinx.coroutines.launch

class PoemViewModel: ViewModel() {
    var randomPoems: List<Poem> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getRandomPoems() {
        viewModelScope.launch {
            val api = ApiService.getInstance()
            try {
                val randomPoemList = api.getRandomPoems()
                randomPoems = randomPoemList
            } catch (e:Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}