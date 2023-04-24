package com.basta.studentbeanstest.domain.use_case.validate_email

import com.basta.studentbeanstest.domain.models.Result

class ValidateEmailUseCase {
    fun execute(email: String): Result {
        if(email.isBlank()) {
            return Result(
                successful = false,
                errorMessage = "The email can't be blank"
            )
        }

        return Result(
            successful = true
        )
    }
}