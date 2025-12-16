package com.safiribytes.landing.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.safiribytes.coreui.components.CustomButtonView
import com.safiribytes.coreui.theme.Theme
import com.safiribytes.coreui.theme.chefapp.ChefAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import com.safiribytes.coreui.R
//import com.safiribytes.recipe.core.components.CustomButtonView
//import com.safiribytes.recipe.ui.theme.RecipeAndroidTheme
//import com.safiribytes.recipe.ui.theme.Theme
import androidx.navigation.NavController
import com.safiribytes.coreui.navigation.Route
import com.safiribytes.landing.presentation.LandingUIEvents

@Composable
fun LandingScreen(
    navController: NavController
) {
    LandingScreenContent(
        onEvent = { events ->
            when(events){
                LandingUIEvents.OnExit -> {

                }
                LandingUIEvents.OnTapGetStarted -> {
                    navController.navigate(Route.DashboardScreen)
                }
            }
        }
    )
}

@Composable
fun LandingScreenContent(
    onEvent: (LandingUIEvents) -> Unit
) {
    Column(
        modifier = Modifier.
        fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.landing),
                contentDescription = "Landing Image",
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent,
                                MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                                MaterialTheme.colorScheme.surface,
                            ),
                            //startY = 0f,
                            //endY = 1000f // Adjust as necessary for your UI
                        )
                    )
            )

            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)
                    .padding( bottom = 20.dp)

            ) {
                Text(
                    text = "Cook Like a Chef",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )

                Spacer( modifier = Modifier.height(10.dp) )

                Text(
                    text = "RecipeApp is a user-friendly recipe app designed for those who are new to cooking and want to try new recipes at home",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    ),

                )

                Spacer( modifier = Modifier.height(30.dp) )

                CustomButtonView(
                    buttonName = "Get started",
                    onTap = {
                        onEvent(LandingUIEvents.OnTapGetStarted)
                    }
                )

            }
        }
    }
}

@Composable
@Preview
fun LandingScreenPreviewLight() {
    UserAppTheme(theme = Theme.Light) {
        LandingScreenContent(
            onEvent = { events ->

            }
        )
    }
}

@Composable
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview()
fun LandingScreenPreviewDark() {
    ChefAppTheme( theme = Theme.Dark) {
        LandingScreenContent(
            onEvent = { events ->

            }
        )
    }
}