package com.safiribytes.recipechef

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.safiribytes.coreui.theme.userapp.UserAppTheme

class ChefMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserAppTheme {
                UserMainScreen()
            }
        }
    }
}

@Composable
fun UserMainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Text(
            text = "Chef App",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

