package com.openinapp.ui.app_navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.openinapp.R
import com.openinapp.ui.theme.BlueRibbon
import com.openinapp.ui.theme.LocalCustomShapes
import com.openinapp.ui.theme.LocalSpacing
import com.openinapp.ui.theme.WildSand

@Composable
fun TopAppBar(currentRoute: String, onClickSettings: () -> Unit) {
    TopAppBar(modifier = Modifier.height(96.dp), backgroundColor = Color.BlueRibbon) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = LocalSpacing.current.medium),
                text = currentRoute.replaceFirstChar { currentRoute[0].uppercase() },
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )

            Icon(
                modifier = Modifier
                    .padding(end = LocalSpacing.current.small)
                    .background(
                        color = Color.WildSand.copy(alpha = .1F),
                        shape = LocalCustomShapes.current.smallShape
                    )
                    .padding(LocalSpacing.current.small)
                    .clickable(onClick = onClickSettings),
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "settings",
                tint = Color.White
            )
        }
    }
}