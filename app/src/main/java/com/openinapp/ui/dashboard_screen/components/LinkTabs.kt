package com.openinapp.ui.dashboard_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.openinapp.R
import com.openinapp.domain.models.Link
import com.openinapp.ui.theme.BlueRibbon
import com.openinapp.ui.theme.LocalCustomShapes
import com.openinapp.ui.theme.LocalSpacing
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LinkTabs(topLinks: List<Link>, recentLinks: List<Link>) {
    var tab by remember { mutableStateOf(LinkType.TopLinks) }
    val pagerState = rememberPagerState { 2 }
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalSpacing.current.medium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(LocalSpacing.current.medium)
            ) {
                TabChip(
                    title = "Top Links",
                    isSelected = tab == LinkType.TopLinks,
                    onClick = {
                        tab = LinkType.TopLinks
                        scope.launch { pagerState.scrollToPage(0) }
                    }
                )

                TabChip(
                    title = "Recent Links",
                    isSelected = tab == LinkType.RecentLinks,
                    onClick = {
                        tab = LinkType.RecentLinks
                        scope.launch { pagerState.scrollToPage(0) }
                    }
                )
            }

            Icon(
                modifier = Modifier
                    .padding(LocalSpacing.current.small)
                    .border(
                        width = .5.dp,
                        color = Color.Gray,
                        shape = LocalCustomShapes.current.smallShape
                    )
                    .padding(LocalSpacing.current.small),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        LinksList(links = if (tab == LinkType.TopLinks) topLinks else recentLinks)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TabChip(title: String, isSelected: Boolean, onClick: () -> Unit) {
    Chip(
        shape = CircleShape,
        onClick = onClick,
        colors = ChipDefaults.chipColors(
            backgroundColor = if (isSelected) Color.BlueRibbon else Color.Transparent,
            contentColor = if (isSelected) Color.White else Color.Gray,
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
        )
    }
}

enum class LinkType {
    TopLinks, RecentLinks
}