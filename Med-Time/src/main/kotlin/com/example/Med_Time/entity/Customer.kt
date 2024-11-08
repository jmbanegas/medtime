package com.example.Med_Time.entity

import jakarta.persistence.*
import org.springframework.data.annotation.Id

@Entity
@Table(name = "customer")
class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var name: String? = null
    var email: String? = null
    var phone: String? = null
    var address: String? = null
    var age: Int? = null

}