package com.safiribytes.dashboard.presentation.views.homepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.safiribytes.coreui.theme.Theme
import com.safiribytes.coreui.theme.chefapp.ChefAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import com.safiribytes.dashboard.presentation.views.RecipeItemView

enum class GridOrientation {
    Vertical,
    Horizontal
}

@Composable
fun RecipesGrid(
    onTap: () -> Unit,
    orientation: GridOrientation = GridOrientation.Vertical
) {
    val columnWidth = 150.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val padding = 5.dp

    val availableWidth = screenWidth - (padding * 2)
    val availableHeight = screenHeight - (padding * 2)

    val columnCount = maxOf((availableWidth / columnWidth).toInt(), 1)
    val rowCount = maxOf((availableHeight / columnWidth).toInt(), 1)

    Box(modifier = Modifier.fillMaxWidth()) {
        when (orientation) {
            GridOrientation.Vertical -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(columnCount),
                    contentPadding = PaddingValues(horizontal = padding),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally)
                ) {
                    items(4) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            RecipeItemView(
                                modifier = Modifier,
                                name = "",
                                rating = "",
                                imageUrl = "",
                                onTap = {}
                            )
                        }
                    }
                }
            }

            GridOrientation.Horizontal -> {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(rowCount),
                    contentPadding = PaddingValues(vertical = padding),
                    verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    items(20) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            RecipeItemView(
                                modifier = Modifier,
                                name = "",
                                rating = "",
                                imageUrl = "",
                                onTap = {}
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RecipesGridPreviewVertical() {
    UserAppTheme(theme = Theme.Light) {
        RecipesGrid(
            onTap = {},
            orientation = GridOrientation.Vertical
        )
    }
}

@Preview
@Composable
fun RecipesGridPreviewHorizontal() {
    ChefAppTheme(theme = Theme.Light) {
        RecipesGrid(
            onTap = {},
            orientation = GridOrientation.Horizontal
        )
    }
}
