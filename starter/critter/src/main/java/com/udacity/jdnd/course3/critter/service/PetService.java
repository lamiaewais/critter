package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.data.entity.Pet;
import java.util.List;

public interface PetService {
    Pet findPetById(Long id);
    Pet savePet(Pet pet);
    List<Pet> getAllPets();
    List<Pet> getPetsByOwner(Long ownerId);
}
