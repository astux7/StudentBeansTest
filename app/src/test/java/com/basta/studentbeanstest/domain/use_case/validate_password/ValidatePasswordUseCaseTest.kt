package com.basta.studentbeanstest.domain.use_case.validate_password

import org.junit.Assert
import org.junit.Before

import org.junit.Test

class ValidatePasswordUseCaseTest {
    private lateinit var validatePassword: ValidatePasswordUseCase
    private lateinit var password: String

    @Before
    fun setUp() {
        validatePassword = ValidatePasswordUseCase()
    }

    @Test
    fun `Given empty for password, result is Error message`() = run {
        password = ""

        val results = validatePassword.execute(password = password)

        Assert.assertTrue(results.errorMessage?.isNullOrEmpty() == false)
        Assert.assertFalse(results.successful)
    }

    @Test
    fun `Given text for password, result is Success`() = run {
        password = "test"

        val results = validatePassword.execute(password = password)

        Assert.assertTrue(results.errorMessage.isNullOrBlank())
        Assert.assertTrue(results.successful)
    }
}
