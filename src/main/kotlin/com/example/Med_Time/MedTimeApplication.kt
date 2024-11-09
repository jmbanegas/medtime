package com.example.Med_Time

import com.example.MedTime.entity.Customer
import com.example.Med_Time.dto.CustomerDto
import com.example.Med_Time.repository.CustomerRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service

@SpringBootApplication
class MedTimeApplication

fun main(args: Array<String>) {
	runApplication<MedTimeApplication>(*args)
}