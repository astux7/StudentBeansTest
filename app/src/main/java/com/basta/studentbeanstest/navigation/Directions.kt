package com.basta.studentbeanstest.navigation

import androidx.navigation.NamedNavArgument

object Directions {
    val sign_in = object : NavigationCommand {
        override val name: String
            get() = "sign_in"
        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    val image_list = object : NavigationCommand {
        override val name: String
            get() = "image_list"
        override val arguments: List<NamedNavArgument>
            get() = emptyList()

    }
}
