package com.example.poetic.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poetic.model.Poem
import com.example.poetic.network.ApiService
import com.example.poetic.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PoemViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()


    init {
        println("INIT")
        loadRandomPoems()
    }

    private fun loadRandomPoems() {
        println("LOAD RANDOM")
        viewModelScope.launch {
            _uiState.value = HomeUiState(isLoading = true, error = null)
            try {
                val randomPoems = retrievePoemsFromApi()
                _uiState.value = HomeUiState(randomPoems = randomPoems, isLoading = false, error = null)
                println("PASS")
            } catch (e: Exception) {
                _uiState.value = HomeUiState(error = "Failed to retrieve poems", isLoading = false, poems = emptyList())
                println("ERROR")
            }
        }
    }

    private suspend fun retrievePoemsFromApi(): List<Poem> {
        // Use Retrofit to retrieve poems from API
        val response = RetrofitInstance.api.getRandomPoems()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw Exception("Failed to retrieve poems")
        }
    }
}