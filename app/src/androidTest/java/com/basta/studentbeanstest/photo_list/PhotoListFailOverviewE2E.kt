package com.basta.studentbeanstest.photo_list

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.basta.studentbeanstest.navigation.Directions
import com.basta.studentbeanstest.navigation.buildTheGraph
import com.basta.studentbeanstest.utils.KoinModuleTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin

class PhotoListFailOverviewE2E {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        stopKoin()

        startKoin {
            modules(KoinModuleTest.failModule())
        }

        composeRule.setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Directions.image_list.name
            ) {
                buildTheGraph(navController)

            }
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun image_list_is_shown_on_fail() {
        // Verify
        composeRule.onNodeWithText("Photos", true).assertIsDisplayed()
        composeRule.onNodeWithText("Log in to your Student Beans account", true)
            .assertDoesNotExist()
        composeRule.onNodeWithText("Try again later", true).assertIsDisplayed()
    }
}