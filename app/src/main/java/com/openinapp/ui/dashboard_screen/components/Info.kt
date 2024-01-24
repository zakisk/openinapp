package com.openinapp.ui.dashboard_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.openinapp.ui.theme.LocalCustomShapes
import com.openinapp.ui.theme.LocalSpacing

@Composable
fun Info(
    @DrawableRes iconId: Int,
    color: Color,
    kind: String,
    value: String
) {
    Column(
        modifier = Modifier
            .width(144.dp)
            .height(152.dp)
            .padding(LocalSpacing.current.small)
            .background(color = Color.White, shape = LocalCustomShapes.current.smallShape)
    ) {
        Icon(
            modifier = Modifier
                .padding(LocalSpacing.current.small)
                .background(color = color.copy(alpha = .1F), shape = CircleShape)
                .padding(LocalSpacing.current.small),
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Text(
            modifier = Modifier.padding(LocalSpacing.current.small),
            text = value,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            modifier = Modifier.padding(LocalSpacing.current.small),
            text = kind,
            style = MaterialTheme.typography.labelLarge.copy(color = Color.Gray),
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis
        )
    }
}