package com.openinapp.ui.app_navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.openinapp.ui.app_navigation.components.BottomAppBar
import com.openinapp.ui.app_navigation.components.TopAppBar
import com.openinapp.ui.theme.BlueRibbon
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route ?: " "
    BackHandler(enabled = scaffoldState.drawerState.isOpen) {
        scope.launch { scaffoldState.drawerState.close() }
    }


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                currentRoute = currentRoute,
                onClickSettings = {}
            )
        },
        bottomBar = {
            BottomAppBar(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = CircleShape,
                containerColor = Color.BlueRibbon,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerGesturesEnabled = false
    ) { paddingValues ->
        MainNavHost(navController = navController, paddingValues = paddingValues)
    }
}