package com.basta.studentbeanstest.domain.models

data class Result(
    val successful: Boolean,
    val errorMessage: String? = null
)