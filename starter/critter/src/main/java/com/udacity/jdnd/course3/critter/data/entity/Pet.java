package com.udacity.jdnd.course3.critter.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udacity.jdnd.course3.critter.pet.PetType;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated
    private PetType type;
    private String name;
    private LocalDate birthDate;
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Customer customer;

    public Pet() {
    }

    public Pet(long id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public Pet(PetType type, String name, LocalDate birthDate, String notes, Customer customer) {
        this.type = type;
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
