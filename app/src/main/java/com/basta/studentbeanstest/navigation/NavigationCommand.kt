package com.basta.studentbeanstest.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val name: String
    val route: String
    val arguments: List<NamedNavArgument>
}
