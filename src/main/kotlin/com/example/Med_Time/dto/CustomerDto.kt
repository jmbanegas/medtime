package com.example.Med_Time.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

class CustomerDto {
    var id: Long? = null

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    var name: String? = null

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    var email: String? = null

    var phone: String? = null
    var address: String? = null
    var dateOfBirth: LocalDate? = null
}