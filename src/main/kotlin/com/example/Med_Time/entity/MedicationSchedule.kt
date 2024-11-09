package com.example.MedTime.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "medication_schedule")
class MedicationSchedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    var customer: Customer,

    @Column(nullable = false)
    var medicationName: String,

    @Column(nullable = false)
    var dosage: String,

    @Column(nullable = false)
    var frequency: String,

    @Column(nullable = false)
    var nextDoseTime: LocalTime,

    @Column(nullable = false)
    var startDate: LocalDate,

    var endDate: LocalDate? = null,

    @Column(nullable = false)
    var notifications: Boolean = true
)

