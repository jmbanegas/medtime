package com.example.Med_Time.mapper

import com.example.MedTime.entity.MedicationSchedule
import com.example.Med_Time.dto.MedicationScheduleDto

object MedicationScheduleMapper {
    fun toEntity(medicationScheduleDto: MedicationScheduleDto): MedicationSchedule {
        val medicationSchedule = MedicationSchedule(
            id = TODO(),
            customer = TODO(),
            medicationName = TODO(),
            dosage = TODO(),
            frequency = TODO(),
            nextDoseTime = TODO(),
            startDate = TODO(),
            endDate = TODO(),
            notifications = TODO()
        )
        medicationSchedule.id = medicationScheduleDto.id;
        medicationSchedule.medicationName = medicationScheduleDto.medicationName.toString();
        medicationSchedule.dosage = medicationScheduleDto.dosage.toString();
        medicationSchedule.frequency = medicationScheduleDto.frequency.toString();
        medicationSchedule.nextDoseTime = medicationScheduleDto.nextDoseTime!!;
        medicationSchedule.startDate = medicationScheduleDto.startDate!!;
        medicationSchedule.endDate = medicationScheduleDto.endDate;
        medicationSchedule.notifications = medicationScheduleDto.notifications
        return medicationSchedule
    }


    fun toDto(medicationSchedule: MedicationSchedule): MedicationScheduleDto {
        val medicationScheduleDto = MedicationScheduleDto()
        medicationScheduleDto.id = medicationSchedule.id;
        medicationScheduleDto.medicationName = medicationSchedule.medicationName;
        medicationScheduleDto.dosage = medicationSchedule.dosage;
        medicationScheduleDto.frequency = medicationSchedule.frequency;
        medicationScheduleDto.nextDoseTime = medicationSchedule.nextDoseTime;
        medicationScheduleDto.startDate = medicationSchedule.startDate;
        medicationScheduleDto.endDate = medicationSchedule.endDate;
        medicationScheduleDto.notifications = medicationSchedule.notifications
        return medicationScheduleDto
    }


}