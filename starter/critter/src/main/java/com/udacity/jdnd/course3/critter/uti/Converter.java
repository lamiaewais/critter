package com.udacity.jdnd.course3.critter.uti;

import com.udacity.jdnd.course3.critter.data.entity.Customer;
import com.udacity.jdnd.course3.critter.data.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
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
        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getNotes(),
                Collections.emptyList()
        );

        if (customerDTO.getPetIds() != null) {
            customer.setPets(
                    customerDTO
                            .getPetIds()
                            .stream()
                            .map(id -> new Pet(id, customer))
                            .collect(Collectors.toList())
            );
        }
        return customer;
    }

    public static PetDTO convertPetToPetDto(Pet pet) {
        return new PetDTO(
                pet.getId(),
                pet.getType(),
                pet.getName(),
                pet.getCustomer().getId(),
                pet.getBirthDate(),
                pet.getNotes()
        );
    }

    public static Pet convertPetDtoToPet(PetDTO pet) {
        Customer customer =  new Customer();
        customer.setId(pet.getOwnerId());
        return new Pet(
                pet.getType(),
                pet.getName(),
                pet.getBirthDate(),
                pet.getNotes(),
                customer

        );
    }
}
