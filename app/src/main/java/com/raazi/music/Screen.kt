package com.raazi.music

import androidx.annotation.DrawableRes

sealed class Screen(val title: String, val route: String) {

    sealed class DrawerScreen(val dTitle: String,
        val dRoute: String,
        @DrawableRes val icon: Int): Screen(dTitle, dRoute){
        object Account: DrawerScreen(
            "Account",
            "account",
            R.drawable.baseline_account_circle_24
        )
        object Subscription: DrawerScreen(
            "Subscription",
            "subscribe",
            R.drawable.baseline_library_add_24
        )
        object AddAccount: DrawerScreen(
            "Add Account",
            "add_account",
            R.drawable.baseline_person_add_alt_1_24
        )
    }
}

val screensInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.Subscription
)