package com.basta.studentbeanstest.domain.use_case.authenticate

import  com.basta.studentbeanstest.domain.models.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/*
TODO:
 update this useCase for implementation real authentication,
 this is just a dummy output
 */

class AuthenticateUseCase {
    operator fun invoke(email: String, password: String): Flow<Result> = flow {
        try {
            emit(Result(successful = true))

        } catch (e: Exception) {
            emit(Result(successful = false, errorMessage = "Can not authenticate user"))
        }
    }
}