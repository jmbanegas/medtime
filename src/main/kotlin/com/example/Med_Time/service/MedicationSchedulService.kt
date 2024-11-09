package com.example.Med_Time.service

import com.example.MedTime.entity.MedicationSchedule
import com.example.Med_Time.dto.MedicationScheduleDto
import com.example.Med_Time.mapper.MedicationScheduleMapper
import com.example.Med_Time.repository.CustomerRepository
import com.example.Med_Time.repository.MedicationScheduleRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MedicationScheduleService {

    @Autowired
    lateinit var medicationScheduleRepository: MedicationScheduleRepository

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var medicationScheduleMapper: MedicationScheduleMapper // Inject the mapper

    // Obtener todos los planes de medicación por el ID del cliente
    fun getMedicationSchedulesByCustomerId(customerId: Long): List<MedicationScheduleDto> {
        val medicationSchedules = medicationScheduleRepository.findByCustomer_Id(customerId)
        return medicationSchedules.map { medicationScheduleMapper.toDto(it) } // Use the mapper directly
    }

    // Crear un nuevo plan de medicación
    fun saveMedicationSchedule(dto: MedicationScheduleDto): MedicationScheduleDto {
        val customer = customerRepository.findById(dto.customerId!!)
            .orElseThrow { EntityNotFoundException("Customer not found with id: ${dto.customerId}") }

        val medicationSchedule = MedicationSchedule(
            customer = customer,
            medicationName = dto.medicationName!!,
            dosage = dto.dosage!!,
            frequency = dto.frequency!!,
            nextDoseTime = dto.nextDoseTime!!,
            startDate = dto.startDate!!,
            endDate = dto.endDate,
            notifications = dto.notifications
        )

        val savedMedicationSchedule = medicationScheduleRepository.save(medicationSchedule)
        return medicationScheduleMapper.toDto(savedMedicationSchedule) // Use the mapper directly
    }

    // Obtener un plan de medicación por su ID
    fun getMedicationScheduleById(id: Long): MedicationScheduleDto {
        val medicationSchedule = medicationScheduleRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Medication schedule not found with id: $id") }
        return medicationScheduleMapper.toDto(medicationSchedule) // Use the mapper directly
    }

    // Actualizar un plan de medicación completo
    fun updateMedicationSchedule(id: Long, dto: MedicationScheduleDto): MedicationScheduleDto {
        val medicationSchedule = medicationScheduleRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Medication schedule not found with id: $id") }

        // Update the medication schedule entity with the new values
        medicationSchedule.medicationName = dto.medicationName ?: medicationSchedule.medicationName
        medicationSchedule.dosage = dto.dosage ?: medicationSchedule.dosage
        medicationSchedule.frequency = dto.frequency ?: medicationSchedule.frequency
        medicationSchedule.nextDoseTime = dto.nextDoseTime ?: medicationSchedule.nextDoseTime
        medicationSchedule.startDate = dto.startDate ?: medicationSchedule.startDate
        medicationSchedule.endDate = dto.endDate ?: medicationSchedule.endDate
        medicationSchedule.notifications = dto.notifications ?: medicationSchedule.notifications

        val updatedMedicationSchedule = medicationScheduleRepository.save(medicationSchedule)
        return medicationScheduleMapper.toDto(updatedMedicationSchedule) // Use the mapper directly
    }

    // Eliminar un plan de medicación
    fun deleteMedicationSchedule(id: Long) {
        val medicationSchedule = medicationScheduleRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Medication schedule not found with id: $id") }
        medicationScheduleRepository.delete(medicationSchedule)
    }
}