package com.example.MedTime.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "customer")
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false, unique = true)
    var email: String? = null

    var phone: String? = null

    var address: String? = null

    @Column(name = "date_of_birth")
    var dateOfBirth: LocalDate? = null

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val medicationSchedules: List<MedicationSchedule> = listOf()
}
