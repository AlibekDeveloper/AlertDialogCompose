package com.example.alertdialogcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var isDialogShow by mutableStateOf(false)

    fun onBuyClick() {
        isDialogShow = true
    }

    fun onDismissDialog() {
        isDialogShow = false
    }
}