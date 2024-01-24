package com.openinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.openinapp.domain.misc.SharedPreferencesUtil
import com.openinapp.ui.app_navigation.MainScreen
import com.openinapp.ui.theme.App
import com.openinapp.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import java.security.KeyStore

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // putting it directly here because this app doesn't have login api call and thus can't retrieve token dynamically
        SharedPreferencesUtil(this).put(
            Constants.TOKEN,
            "TOKEN" // put token here
        )
        setContent {
            App {
                MainScreen()
            }
        }
    }
}

