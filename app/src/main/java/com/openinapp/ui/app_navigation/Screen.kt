package com.openinapp.ui.app_navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.openinapp.R


sealed class Screen(val route: String) {

    data object DashboardScreen : Screen("dashboard")

    data object SettingsScreen : Screen("settings")

    sealed class BottomScreen(
        val bottomRoute: String,
        @StringRes val strResId: Int,
        @DrawableRes val iconId: Int
    ) : Screen(bottomRoute) {

        data object LinksScreen : BottomScreen("links", R.string.links, R.drawable.ic_link)

        data object CoursesScreen : BottomScreen("courses", R.string.courses, R.drawable.ic_courses)

        data object CampaignsScreen : BottomScreen("campaigns", R.string.campaigns, R.drawable.ic_campaigns)

        data object ProfileScreen : BottomScreen("chat", R.string.profile, R.drawable.ic_profile)

    }

}
