package com.example.kabar.presentation.screens.Profile

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.example.kabar.presentation.state.AppViewModel

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    appViewModel: AppViewModel
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Dark Mode")

            Switch(
                checked = isDarkTheme,
                onCheckedChange = { onThemeToggle() }
            )
        }
    }
}
