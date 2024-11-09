package com.example.Med_Time.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalTime

class MedicationScheduleDto {
    var id: Long? = null

    @NotNull(message = "Customer ID is required")
    var customerId: Long? = null

    @NotNull(message = "Medication Name is required")
    @NotBlank(message = "Medication Name is required")
    var medicationName: String? = null

    @NotNull(message = "Dosage is required")
    var dosage: String? = null

    @NotNull(message = "Frequency is required")
    var frequency: String? = null

    @NotNull(message = "Next Dose Time is required")
    var nextDoseTime: LocalTime? = null

    @NotNull(message = "Start Date is required")
    var startDate: LocalDate? = null

    var endDate: LocalDate? = null
    var notifications: Boolean = true
}
