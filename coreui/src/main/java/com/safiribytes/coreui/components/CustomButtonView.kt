package com.safiribytes.coreui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun CustomButtonView(
    buttonName: String,
    //textColor: Color =  if (isSystemInDarkTheme()) Color.White else Color.Black,
    textColor: Color = Color.White,
    width: Dp = Dp.Unspecified, // Dp.Unspecified for infinity
    height: Dp = 40.dp,
    leadingImage: String = "",
    leadingIcon: Int? = null, // use Int for drawable resource
    image: String = "",
    icon: Int? = null, // use Int for drawable resource
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = MaterialTheme.colorScheme.primary,
    disabledTextColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    modifier: Modifier = Modifier, // Add modifier to allow customization
    isEnabled: Boolean = true,
    onTap:()-> Unit,
){
    Box(
        modifier = modifier
            //.fillMaxWidth()
            .height(height)
            .width(width)
            .background(
                color = if (isEnabled) backgroundColor else Color.Gray ,
                shape = RoundedCornerShape(10.dp) // Apply rounded corners here
            )
            .border(
                width = 1.dp,
                color = if (isEnabled) borderColor else Color.Gray,
                shape = RoundedCornerShape(10.dp) // Match rounded border
            )
            .clickable(enabled = isEnabled) {
                onTap()
            }
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ){
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            if(leadingImage.isNotEmpty()){
                Image(
                    painter = rememberAsyncImagePainter(leadingImage),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp, 24.dp)
                )
            }

            if(leadingIcon != null){
                Image(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp, 24.dp)
                )
            }

            Text(
                text = buttonName,
                color = if (isEnabled) textColor else disabledTextColor,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 4.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            if(image.isNotEmpty()){
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp, 24.dp)
                )
            }

            if(icon != null){
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp, 24.dp)
                )
            }
        }
    }
}