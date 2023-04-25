package com.basta.studentbeanstest.presentation.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basta.studentbeanstest.domain.use_case.authenticate.AuthenticateUseCase
import com.basta.studentbeanstest.domain.use_case.validate_email.ValidateEmailUseCase
import com.basta.studentbeanstest.domain.use_case.validate_password.ValidatePasswordUseCase
import com.basta.studentbeanstest.navigation.Directions
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SignInViewModel(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {
    var state by mutableStateOf(SignInFormState())
        private set

    private var authenticated by mutableStateOf(false)

    fun submit(email: String, password: String, navigateTo: (String) -> Unit) {
        if (!isValid(email, password)) {
            return
        }

        authenticateUseCase(state.email, state.password).onEach { result ->
            authenticated = result.successful

            if (authenticated) {
                navigateTo(Directions.image_list.name)
            }

        }.launchIn(viewModelScope)
    }

    private fun isValid(email: String, password: String): Boolean {
        val emailResult = validateEmailUseCase.execute(email)
        val passwordResult = validatePasswordUseCase.execute(password)

        val hasError = listOf(
            emailResult,
            passwordResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )

        }

        return !hasError
    }
}