package com.basta.studentbeanstest.navigation

import androidx.navigation.NamedNavArgument

object Directions {
    val sign_in = object : NavigationCommand {
        override val route: String
            get() = "sign_in"
        override val name: String
            get() = route
        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    val image_list = object : NavigationCommand {
        override val route: String
            get() = "image_list"
        override val name: String
            get() = route
        override val arguments: List<NamedNavArgument>
            get() = emptyList()

    }
}
