package com.example.Med_Time.service

import com.example.MedTime.entity.Customer
import com.example.Med_Time.dto.CustomerDto
import com.example.Med_Time.mapper.CustomerMapper
import com.example.Med_Time.repository.CustomerRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var customerMapper: CustomerMapper

    // Obtener todos los clientes
    fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    // Obtener un cliente por su ID
    fun getCustomerById(id: Long): Customer {
        return customerRepository.findById(id).orElseThrow { EntityNotFoundException("Customer not found with id: $id") }
    }

    // Guardar un nuevo cliente
    fun saveCustomer(customerDto: CustomerDto): Customer {
        val customer = customerMapper.toEntity(customerDto)
        return customerRepository.save(customer)
    }

    // Actualizar un cliente existente
    fun updateCustomer(id: Long, customerDto: CustomerDto): Customer {
        if (!customerRepository.existsById(id)) {
            throw EntityNotFoundException("Customer not found with id: $id")
        }
        val customer = customerMapper.toEntity(customerDto)
        customer.id = id
        return customerRepository.save(customer)
    }

    // Eliminar un cliente por su ID
    fun deleteCustomer(id: Long) {
        if (!customerRepository.existsById(id)) {
            throw EntityNotFoundException("Customer not found with id: $id")
        }
        customerRepository.deleteById(id)
    }
}