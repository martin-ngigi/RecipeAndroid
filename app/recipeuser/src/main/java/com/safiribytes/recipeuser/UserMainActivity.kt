package com.safiribytes.recipeuser

import android.os.Bundle
import android.os.PersistableBundle
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
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.safiribytes.core.utils.AppType
import com.safiribytes.coreui.navigation.Route
import com.safiribytes.coreui.theme.RecipeAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserMainActivity : ComponentActivity() {

    @Volatile
    private var keepSplash = true  // start as true

    private lateinit var navController: NavHostController

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

        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()
            RecipeAppTheme(
                appType = AppType.USER,
                content = {
                    val initialRoute = Route.LandingScreen.route
                    RecipeUserNavigation(
                        startDestination = initialRoute,
                        navController = navController,
                        isDrawerOpened = false,
                        onDrawerOpen = {  isOpen ->

                        }
                    )
                }
            )
        }
    }
}

