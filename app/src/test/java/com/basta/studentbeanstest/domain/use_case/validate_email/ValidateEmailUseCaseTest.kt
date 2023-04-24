package com.basta.studentbeanstest.domain.use_case.validate_email

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ValidateEmailUseCaseTest {
    private lateinit var validateEmail: ValidateEmailUseCase
    private lateinit var email: String

    @Before
    fun setUp() {
        validateEmail = ValidateEmailUseCase()
    }

    @Test
    fun `Given empty for email, result is Error message`() = run {
        email = ""

        val results = validateEmail.execute(email = email)

        Assert.assertTrue(results.errorMessage?.isNullOrEmpty() == false)
        Assert.assertFalse(results.successful)
    }

    @Test
    fun `Given text for email, result is Success`() = run {
        email = "test@inbox.lt"

        val results = validateEmail.execute(email = email)

        Assert.assertTrue(results.errorMessage.isNullOrBlank())
        Assert.assertTrue(results.successful)
    }
}