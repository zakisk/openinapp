package com.openinapp.ui.dashboard_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.openinapp.ui.theme.LocalCustomShapes
import com.openinapp.ui.theme.LocalSpacing

@Composable
fun ViewButton(@DrawableRes iconId: Int, text: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.medium)
            .border(
                width = .5.dp,
                shape = LocalCustomShapes.current.smallShape,
                color = Color.Gray.copy(alpha = .2F)
            )
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.padding(
                end = LocalSpacing.current.small,
                top = LocalSpacing.current.medium,
                bottom = LocalSpacing.current.medium
            ),
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Text(
            modifier = Modifier.padding(
                start = LocalSpacing.current.small,
                top = LocalSpacing.current.medium,
                bottom = LocalSpacing.current.medium
            ),
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
    }
}