package com.safiribytes.coreui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.safiribytes.coreui.extensions.customCardStyle
import com.safiribytes.coreui.theme.Theme
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import org.w3c.dom.Text

@Composable
fun EmptyStateView(
    message: String,
    subMessage: String = "",
    icon: ImageVector? = Icons.Default.DeleteOutline,
    onTapButtonName: String = "",
    onTap: ()-> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .customCardStyle(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (icon != null){
            Icon(
                imageVector = icon,
                contentDescription = message,
                modifier = modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.onSurface
        )

        if (subMessage.isNotEmpty()){
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = subMessage,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    color =  MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }

        if (onTapButtonName.isNotEmpty()){
            Spacer(modifier = Modifier.height(24.dp))

            Button(onTap) {
                Text(
                    onTapButtonName,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

    }
}

@Preview
@Composable
fun EmptyStatePreview(){
    UserAppTheme(theme = Theme.Dark) {
        EmptyStateView(
            message = "Empty",
            subMessage = "No items found, please retry by clicking button below",
            onTapButtonName = "Retry",
            onTap = {

            }
        )
    }
}