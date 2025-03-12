package com.vipulasri.jetinstagram.ui.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Add() {
    Column(
        modifier = Modifier
            .padding(vertical = 32.dp, horizontal = 16.dp)
    ) {
        Text(text = "AddNew Page")
    }
}