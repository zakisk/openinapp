package com.openinapp.ui.app_navigation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.openinapp.ui.app_navigation.Screen
import com.openinapp.ui.theme.Manatee


@Composable
fun BottomAppBar(navController: NavHostController) {

    val items = listOf(
        Screen.BottomScreen.LinksScreen,
        Screen.BottomScreen.CoursesScreen,
        Screen.BottomScreen.CoursesScreen, // kept it twice intentionally to justify padding around floating action button
        Screen.BottomScreen.CampaignsScreen,
        Screen.BottomScreen.ProfileScreen
    )

    BottomAppBar(
        backgroundColor = MaterialTheme.colorScheme.background,
        cutoutShape = CircleShape
    ) {
        val currentDestination by navController.currentBackStackEntryAsState()
        val currentRoute = currentDestination?.destination

        items.forEachIndexed { index, screen ->
            if (index != 2) {
                BottomNavigationItem(
                    label = {
                        Text(
                            text = stringResource(id = screen.strResId),
                            fontSize = 10.sp,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.iconId),
                            contentDescription = screen.route.replaceFirstChar { it.uppercase() }
                        )
                    },
                    selected = currentRoute?.hierarchy?.any { it.route == screen.bottomRoute } == true,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Manatee,
                    onClick = {
                        if (screen.bottomRoute != currentRoute?.route) {
                            navController.navigate(screen.route) {
                                navController.popBackStack(
                                    route = Screen.DashboardScreen.route,
                                    inclusive = false
                                )
                            }
                        }
                    }
                )
            } else {
                BottomNavigationItem(
                    icon = {},
                    label = { },
                    selected = false,
                    onClick = { },
                    enabled = false
                )
            }
        }

    }
}