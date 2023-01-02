package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.data.entity.Pet;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.uti.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import static com.udacity.jdnd.course3.critter.uti.Converter.convertPetDtoToPet;
import static com.udacity.jdnd.course3.critter.uti.Converter.convertPetToPetDto;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet savedPet = petService.savePet(convertPetDtoToPet(petDTO));
        return Converter.convertPetToPetDto(savedPet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return convertPetToPetDto(petService.findPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets() {
        return petService
                .getAllPets()
                .stream()
                .map(Converter::convertPetToPetDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        return petService
                .getPetsByOwner(ownerId)
                .stream()
                .map(Converter::convertPetToPetDto)
                .collect(Collectors.toList());
    }
}
