package com.example.Med_Time.mapper

import com.example.MedTime.entity.Customer
import com.example.Med_Time.dto.CustomerDto
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Component

object CustomerMapper {

    fun toEntity(customerDto: CustomerDto): Customer {
        val customer = Customer()
        customer.id = customerDto.id;
        customer.name = customerDto.name;
        customer.email = customerDto.email;
        customer.phone = customerDto.phone;
        customer.address = customerDto.address;
        customer.dateOfBirth = customerDto.dateOfBirth
        return customer
    }


    fun toDto(customer: Customer): CustomerDto {
        val customerDto = CustomerDto()
        customerDto.id = customer.id;
        customerDto.name = customer.name;
        customerDto.email = customer.email;
        customerDto.phone = customer.phone;
        customerDto.address = customer.address;
        customerDto.dateOfBirth = customer.dateOfBirth
        return customerDto
    }
}