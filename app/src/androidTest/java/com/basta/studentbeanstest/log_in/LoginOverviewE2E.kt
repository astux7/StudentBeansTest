package com.basta.studentbeanstest.log_in

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
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

class LoginOverviewE2E {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        stopKoin()

        startKoin {
            modules(KoinModuleTest.successModule())
        }

        composeRule.setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Directions.sign_in.name
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
    fun log_in_page_is_shown() {
        // Verify
        composeRule.onNodeWithText("Welcome back", true).assertIsDisplayed()
        composeRule.onNodeWithText("Log in to your Student Beans account", true).assertIsDisplayed()
    }

    @Test
    fun button_click_brings_fields_error() {
        // When
        composeRule.onNodeWithText("Log in").performClick()
        // Verify
        composeRule.onNodeWithText("The email can't be blank").assertExists()
        composeRule.onNodeWithText("The password needs to consist of at least 1 characters")
            .assertExists()
    }

    @Test
    fun button_click_brings_field_error_for_empty_email() {
        // Given
        composeRule.onNodeWithText("Password").performTextInput("password")

        // When
        composeRule.onNodeWithText("Log in").performClick()
        // Verify
        composeRule.onNodeWithText("The email can't be blank").assertExists()
            .assertExists()
    }

    @Test
    fun button_click_brings_field_error_for_empty_password() {
        // Given
        composeRule.onNodeWithText("Email").performTextInput("email")

        // When
        composeRule.onNodeWithText("Log in").performClick()
        // Verify
        composeRule.onNodeWithText("The password needs to consist of at least 1 characters")
            .assertExists()
    }

    @Test
    fun filled_fields_on_click_button_shows_next_screen() {
        // Given
        composeRule.onNodeWithText("Email").performTextInput("email")
        composeRule.onNodeWithText("Password").performTextInput("password")

        // When
        composeRule.onNodeWithText("Log in").performClick()

        // Verify
        composeRule.onNodeWithText("Photos").assertExists()
    }

}