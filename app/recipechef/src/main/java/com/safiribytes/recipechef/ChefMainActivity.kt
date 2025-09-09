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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChefMainActivity : ComponentActivity() {
    @Volatile
    private var keepSplash = true  // start as true

    override fun onCreate(savedInstanceState: Bundle?) {
        // Install splash before super.onCreate
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        // Keep splash visible while condition is true
        splashScreen.setKeepOnScreenCondition { keepSplash }

        // Delay splash for 3 seconds
        lifecycleScope.launch {
            delay(2000)
            keepSplash = false
        }
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

