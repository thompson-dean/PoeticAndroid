package com.example.poetic.viewmodel

import com.example.poetic.model.Poem

data class HomeUiState(
    val isLoading: Boolean = false,
    val randomPoems: List<Poem> = emptyList(),
    val poems: List<Poem> = emptyList(),
    val error: String? = null
)
