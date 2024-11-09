package com.example.Med_Time.repository

import com.example.MedTime.entity.MedicationSchedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface MedicationScheduleRepository : JpaRepository<MedicationSchedule, Long>{

    fun findByCustomer_Id(customerId: Long): List<MedicationSchedule>
}