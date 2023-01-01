package com.udacity.jdnd.course3.critter.uti;

import com.udacity.jdnd.course3.critter.data.entity.Customer;
import com.udacity.jdnd.course3.critter.data.entity.Pet;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;

import java.util.Collections;
import java.util.stream.Collectors;

public class Converter {

    public static CustomerDTO convertCustomerIntoCustomerDto(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getPhoneNumber(),
                customer.getNotes(),
                customer.getPets().stream().map(Pet::getId).collect(Collectors.toList())
        );
    }

    public static Customer convertCustomerDtoIntoCustomer(CustomerDTO customerDTO) {
        Customer customer =  new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getNotes(),
                Collections.emptyList()
        );

        customer.setPets(
                customerDTO
                .getPetIds()
                .stream()
                .map(id -> new Pet(id, customer))
                .collect(Collectors.toList())
        );
        return customer;
    }
}
