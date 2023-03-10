package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.entity.Customer;
import com.udacity.jdnd.course3.critter.exception.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.exception.PetNotFoundException;
import com.udacity.jdnd.course3.critter.data.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Pet findPetById(Long id) {
        return petRepository.findById(id).orElseThrow(PetNotFoundException::new);
    }

    @Override
    public Pet savePet(Pet pet) {
        Customer customer = customerRepository.findById(pet.getCustomer().getId()).orElseThrow(CustomerNotFoundException::new);
        Pet savedPet = petRepository.save(pet);
        customer.addPet(savedPet);
        return savedPet;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> getPetsByOwner(Long ownerId) {
        if (!customerRepository.existsById(ownerId)) {
            throw new CustomerNotFoundException();
        }

        return petRepository.findByCustomerId(ownerId);
    }
}
