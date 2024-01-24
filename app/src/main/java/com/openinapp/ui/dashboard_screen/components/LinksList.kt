package com.openinapp.ui.dashboard_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.openinapp.domain.models.Link

@Composable
fun LinksList(links: List<Link>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        links.forEach { link ->
            LinkItem(link = link)
        }
    }
}