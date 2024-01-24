package com.openinapp.ui.dashboard_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.openinapp.R
import com.openinapp.ui.theme.BlueRibbon
import com.openinapp.ui.theme.LocalSpacing
import com.openinapp.ui.theme.PurpleHeart
import com.openinapp.ui.theme.WildWatermelon

@Composable
fun InfoItems(todayClick: Int, topLocation: String, topSource: String) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.small)
    ) {
        item {
            Info(
                iconId = R.drawable.ic_clicks,
                color = Color.PurpleHeart,
                kind = "Today's clicks",
                value = todayClick.toString()
            )

            Info(
                iconId = R.drawable.ic_location,
                color = Color.BlueRibbon,
                kind = "Top Location",
                value = topLocation
            )

            Info(
                iconId = R.drawable.ic_globe,
                color = Color.WildWatermelon,
                kind = "Top Source",
                value = topSource
            )
        }
    }
}