package com.safiribytes.dashboard.presentation.views

import android.widget.ScrollView
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DashboardScreen(
    navController: NavController
){
    Column {
        Text("Dashboard")
    }
}