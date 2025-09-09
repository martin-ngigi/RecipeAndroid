package com.safiribytes.dashboard.presentation.views.homepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.safiribytes.coreui.components.CustomImageView
import com.safiribytes.coreui.extensions.customCardStyle
import com.safiribytes.coreui.theme.Theme
import com.safiribytes.coreui.theme.chefapp.ChefAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme

@Composable
fun ChefHomeRow(){
    Row (
        modifier = Modifier
            .customCardStyle(padding = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        CustomImageView(
            url = "",
            maxWidth = 50.dp,
            height = 50.dp,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Chef Martin",
                style = MaterialTheme.typography.bodyMedium.copy(
                )
            )

            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Text(
                    text = "4.5",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.padding(start = 4.dp)
                )
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(14.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun ChefHomeRowPreviewLight(){
    ChefAppTheme(theme = Theme.Light) {
        ChefHomeRow()
    }
}

@Preview
@Composable
fun ChefHomeRowPreviewDark(){
    UserAppTheme(theme = Theme.Dark) {
        ChefHomeRow()
    }
}