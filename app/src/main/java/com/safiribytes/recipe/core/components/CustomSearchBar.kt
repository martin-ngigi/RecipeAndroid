package com.safiribytes.recipe.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.safiribytes.recipe.ui.theme.RecipeAndroidTheme
import com.safiribytes.recipe.ui.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Search...",
    leadingIcon: @Composable (() -> Unit)? = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
    trailingIcon: @Composable (() -> Unit)? = null,
    results: List<String> = emptyList(),
    onResultClick: (String) -> Unit
) {
    var isActive by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Text(
                    text = placeholder,
                    //color = MaterialTheme.colorScheme.onSurface
                )
            },
            leadingIcon = leadingIcon,
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = { onQueryChange("") }) {
                        Icon(Icons.Default.Close, contentDescription = "Clear Search")
                    }
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch(query) }),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp), // Add shape here
            colors = TextFieldDefaults.colors(
                focusedContainerColor =  Color.LightGray.copy(alpha = 0.5f),
                unfocusedContainerColor =  Color.LightGray.copy(alpha = 0.5f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        if (isActive && results.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 300.dp)
            ) {
                items(results) { result ->
                    Text(
                        text = result,
                       // color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onResultClick(result)
                                isActive = false
                            }
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun CustomSearchBarPreviewLight(){
    RecipeAndroidTheme(theme = Theme.Light) {
        CustomSearchBar(
            query = "",
            onQueryChange = { newValue ->
            },
            onSearch = {
            },
            //results = ,
            onResultClick = {

            }
        )
    }
}

@Composable
@Preview
fun CustomSearchBarPreviewDark(){
    RecipeAndroidTheme(theme = Theme.Dark) {
        CustomSearchBar(
            query = "",
            onQueryChange = { newValue ->
            },
            onSearch = {
            },
            //results = ,
            onResultClick = {

            }
        )
    }
}