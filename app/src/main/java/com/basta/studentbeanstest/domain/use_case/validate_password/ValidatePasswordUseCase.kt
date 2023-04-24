package com.basta.studentbeanstest.domain.use_case.validate_password

import com.basta.studentbeanstest.common.Constants.PASSWORD_LENGTH
import com.basta.studentbeanstest.domain.models.Result

class ValidatePasswordUseCase {

    fun execute(password: String): Result {
        if(password.length < PASSWORD_LENGTH) {
            return Result(
                successful = false,
                errorMessage = "The password needs to consist of at least $PASSWORD_LENGTH characters"
            )
        }
        return Result(
            successful = true
        )
    }

}