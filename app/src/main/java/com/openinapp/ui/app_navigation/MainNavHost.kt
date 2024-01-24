package com.openinapp.ui.app_navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.openinapp.ui.dashboard_screen.DashboardScreen

@Composable
fun MainNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = Screen.DashboardScreen.route
    ) {
        composable(route = Screen.DashboardScreen.route) {
            DashboardScreen()
        }

        composable(route = Screen.SettingsScreen.route) {
            Label(text = "Settings")
        }

        composable(route = Screen.BottomScreen.LinksScreen.route) {
            Label(text = "Links")
        }

        composable(route = Screen.BottomScreen.CoursesScreen.route) {
            Label(text = "Courses")
        }

        composable(route = Screen.BottomScreen.CampaignsScreen.route) {
            Label(text = "Campaigns")
        }

        composable(route = Screen.BottomScreen.ProfileScreen.route) {
            Label(text = "Profile")
        }
    }
}

@Composable
fun Label(text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}