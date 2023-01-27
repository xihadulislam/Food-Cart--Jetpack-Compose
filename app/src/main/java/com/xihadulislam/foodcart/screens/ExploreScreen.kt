package com.xihadulislam.foodcart.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun ExploreScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        Alignment.Center
    ) {
        Text(
            text = navController.currentDestination?.route.toString(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(color = Color.Yellow)
        )
    }
}

