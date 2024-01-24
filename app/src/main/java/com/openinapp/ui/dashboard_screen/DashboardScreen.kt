package com.openinapp.ui.dashboard_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.openinapp.R
import com.openinapp.ui.dashboard_screen.components.Chart
import com.openinapp.ui.dashboard_screen.components.ContactButton
import com.openinapp.ui.dashboard_screen.components.Greeting
import com.openinapp.ui.dashboard_screen.components.InfoItems
import com.openinapp.ui.dashboard_screen.components.LinkTabs
import com.openinapp.ui.dashboard_screen.components.ViewButton
import com.openinapp.ui.theme.BlueRibbon
import com.openinapp.ui.theme.WildSand

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = hiltViewModel()) {
    val state by viewModel.state
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.WildSand)
    ) {
        item {

            Greeting()
            Chart(values = state.dashboardData?.data?.overallUrlChart ?: mapOf())
            InfoItems(
                todayClick = state.dashboardData?.todayClicks ?: 0,
                topLocation = state.dashboardData?.topLocation ?: "Ahmedabad",
                topSource = state.dashboardData?.topSource ?: "Instagram"
            )
            ViewButton(iconId = R.drawable.ic_analytics, text = "View Analytics")
            LinkTabs(
                topLinks = state.dashboardData?.data?.topLinks ?: listOf(),
                recentLinks = state.dashboardData?.data?.recentLinks ?: listOf()
            )

            ViewButton(iconId = R.drawable.ic_link, text = "View all Links")

            ContactButton(iconId = R.drawable.ic_whatsapp, text = "Talk with us")

            ContactButton(iconId = R.drawable.ic_question, text = "Frequently asked questions")

            Spacer(modifier = Modifier.height(64.dp))

            if (state.isLoading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        color = Color.BlueRibbon,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            state.error?.let {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = it,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}