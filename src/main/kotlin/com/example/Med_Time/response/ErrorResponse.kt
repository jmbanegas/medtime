package com.example.Med_Time.response

data class ErrorResponse(
    val status: String = "error",
    val message: String? = null,
    val code: Int? = null
)